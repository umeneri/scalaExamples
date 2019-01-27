# Scalikejdbc tutorial

---

## scalikejdbc?
- SQL-based DB access library for Scala developers
- Amazon Redshift and Facebook Presto support (slick is not supported) 

## demerit:
- blocking io (slick 3.0 is non-blocking)

---

## execute SQL
```scala
sql"""
create table members (
  id serial not null primary key,
  name varchar(64),
  created_at timestamp not null
)
""".execute.apply()
``` 

---

## QueryDSL
```scala
select
      .from(Programmer as p)
      .leftJoin(Company as c).on(p.companyId, c.id)
      .where.eq(p.isDeleted, false)
      .orderBy(p.createdAt)
      .limit(10)
      .offset(0)
```

---

## Transaction

```scala
DB localTx { implicit session => // transactional session
  val id = Product.create("ScalikeJDBC Cookbook", 200) // within transaction
  val product = Product.findById(id) // within transaction
}
```

---

## Code Generation
- generating source and test code by scalikejdbc-mapper-generator


