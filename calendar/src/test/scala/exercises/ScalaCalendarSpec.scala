package exercises

import org.scalatest.FlatSpec
import org.scalatest.Matchers._
import java.time.ZonedDateTime

class ScalaCalendarSpec extends FlatSpec {

  it should "return (date, value) map" in {
    val expectedMap = Map[String, Integer]("2018-11-09" -> 0, "2018-11-08" -> 0, "2018-11-07" -> 1)
    val result = ScalaCalendar.getMap
    result should be(expectedMap)
  }
}
