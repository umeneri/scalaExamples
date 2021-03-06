package models

import scalikejdbc._
import java.time.{ZonedDateTime}

case class Member(
  id: Long,
  name: String,
  description: Option[String] = None,
  createdAt: ZonedDateTime,
  updatedAt: ZonedDateTime) {

  def save()(implicit session: DBSession = Member.autoSession): Member = Member.save(this)(session)

  def destroy()(implicit session: DBSession = Member.autoSession): Int = Member.destroy(this)(session)

}


object Member extends SQLSyntaxSupport[Member] {

  override val tableName = "member"

  override val columns = Seq("id", "name", "description", "created_at", "updated_at")

  def apply(m: SyntaxProvider[Member])(rs: WrappedResultSet): Member = apply(m.resultName)(rs)
  def apply(m: ResultName[Member])(rs: WrappedResultSet): Member = new Member(
    id = rs.get(m.id),
    name = rs.get(m.name),
    description = rs.get(m.description),
    createdAt = rs.get(m.createdAt),
    updatedAt = rs.get(m.updatedAt)
  )

  val m = Member.syntax("m")

  override val autoSession = AutoSession

  def find(id: Long)(implicit session: DBSession = autoSession): Option[Member] = {
    withSQL {
      select.from(Member as m).where.eq(m.id, id)
    }.map(Member(m.resultName)).single.apply()
  }

  def findAll()(implicit session: DBSession = autoSession): List[Member] = {
    withSQL(select.from(Member as m)).map(Member(m.resultName)).list.apply()
  }

  def countAll()(implicit session: DBSession = autoSession): Long = {
    withSQL(select(sqls.count).from(Member as m)).map(rs => rs.long(1)).single.apply().get
  }

  def findBy(where: SQLSyntax)(implicit session: DBSession = autoSession): Option[Member] = {
    withSQL {
      select.from(Member as m).where.append(where)
    }.map(Member(m.resultName)).single.apply()
  }

  def findAllBy(where: SQLSyntax)(implicit session: DBSession = autoSession): List[Member] = {
    withSQL {
      select.from(Member as m).where.append(where)
    }.map(Member(m.resultName)).list.apply()
  }

  def countBy(where: SQLSyntax)(implicit session: DBSession = autoSession): Long = {
    withSQL {
      select(sqls.count).from(Member as m).where.append(where)
    }.map(_.long(1)).single.apply().get
  }

  def create(
    name: String,
    description: Option[String] = None,
    createdAt: ZonedDateTime,
    updatedAt: ZonedDateTime)(implicit session: DBSession = autoSession): Member = {
    val generatedKey = withSQL {
      insert.into(Member).namedValues(
        column.name -> name,
        column.description -> description,
        column.createdAt -> createdAt,
        column.updatedAt -> updatedAt
      )
    }.updateAndReturnGeneratedKey.apply()

    Member(
      id = generatedKey,
      name = name,
      description = description,
      createdAt = createdAt,
      updatedAt = updatedAt)
  }

  def batchInsert(entities: Seq[Member])(implicit session: DBSession = autoSession): List[Int] = {
    val params: Seq[Seq[(Symbol, Any)]] = entities.map(entity =>
      Seq(
        'name -> entity.name,
        'description -> entity.description,
        'createdAt -> entity.createdAt,
        'updatedAt -> entity.updatedAt))
    SQL("""insert into member(
      name,
      description,
      created_at,
      updated_at
    ) values (
      {name},
      {description},
      {createdAt},
      {updatedAt}
    )""").batchByName(params: _*).apply[List]()
  }

  def save(entity: Member)(implicit session: DBSession = autoSession): Member = {
    withSQL {
      update(Member).set(
        column.id -> entity.id,
        column.name -> entity.name,
        column.description -> entity.description,
        column.createdAt -> entity.createdAt,
        column.updatedAt -> entity.updatedAt
      ).where.eq(column.id, entity.id)
    }.update.apply()
    entity
  }

  def destroy(entity: Member)(implicit session: DBSession = autoSession): Int = {
    withSQL { delete.from(Member).where.eq(column.id, entity.id) }.update.apply()
  }

}
