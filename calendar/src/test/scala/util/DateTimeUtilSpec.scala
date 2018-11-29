package util

import org.scalatest.FlatSpec
import org.scalatest.Matchers._
import java.time.ZonedDateTime

class DateTimeUtilSpec extends FlatSpec {
  it should "return monthly all day list for given date" in {
    val zd = ZonedDateTime.now
    val result = DateTimeUtil.getAllDays(zd)
//    result should be
  }

}
