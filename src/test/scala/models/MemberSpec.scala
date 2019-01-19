package models

import org.scalatest._
import scalikejdbc.scalatest.AutoRollback
import scalikejdbc._
import java.time.{ZonedDateTime}


class MemberSpec extends fixture.FlatSpec with Matchers with AutoRollback {
  val m = Member.syntax("m")

  behavior of "Member"

  it should "find by primary keys" in { implicit session =>
    val maybeFound = Member.find(1L)
    maybeFound.isDefined should be(true)
  }
  it should "find by where clauses" in { implicit session =>
    val maybeFound = Member.findBy(sqls.eq(m.id, 1L))
    maybeFound.isDefined should be(true)
  }
  it should "find all records" in { implicit session =>
    val allResults = Member.findAll()
    allResults.size should be >(0)
  }
  it should "count all records" in { implicit session =>
    val count = Member.countAll()
    count should be >(0L)
  }
  it should "find all by where clauses" in { implicit session =>
    val results = Member.findAllBy(sqls.eq(m.id, 1L))
    results.size should be >(0)
  }
  it should "count by where clauses" in { implicit session =>
    val count = Member.countBy(sqls.eq(m.id, 1L))
    count should be >(0L)
  }
  it should "create new record" in { implicit session =>
    val created = Member.create(name = "MyString", createdAt = null, updatedAt = null)
    created should not be(null)
  }
  it should "save a record" in { implicit session =>
    val entity = Member.findAll().head
    // TODO modify something
    val modified = entity
    val updated = Member.save(modified)
    updated should not equal(entity)
  }
  it should "destroy a record" in { implicit session =>
    val entity = Member.findAll().head
    val deleted = Member.destroy(entity)
    deleted should be(1)
    val shouldBeNone = Member.find(1L)
    shouldBeNone.isDefined should be(false)
  }
  it should "perform batch insert" in { implicit session =>
    val entities = Member.findAll()
    entities.foreach(e => Member.destroy(e))
    val batchInserted = Member.batchInsert(entities)
    batchInserted.size should be >(0)
  }
}
