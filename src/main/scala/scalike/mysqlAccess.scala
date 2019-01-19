package scalike

import models.Member
import scalikejdbc._
import scalikejdbc.config._


object mysqlAccess extends App {
  DBs.setupAll()

  Member()

}
