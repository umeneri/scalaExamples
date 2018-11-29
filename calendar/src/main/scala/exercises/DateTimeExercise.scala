package exercises

import java.time.ZonedDateTime

object DateTimeExercise {
  def main(args: Array[String]): Unit = {
    val zd = ZonedDateTime.now()
    zd.getHour

    println(zd)
  }
}
