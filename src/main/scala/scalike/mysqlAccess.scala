package scalike

import models.Member
import scalikejdbc.config._


object mysqlAccess extends App {
  DBs.setupAll()
  val maybeFound = Member.find(1L)
  val name = maybeFound.get.name
  println(name)

}
