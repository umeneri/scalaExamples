package json

import java.time.format.DateTimeFormatter
import java.time.{Instant, ZoneId, ZonedDateTime}

import org.json4s.CustomSerializer
import org.json4s.JsonAST.JObject
import org.json4s.JsonDSL._

class PostSerializer extends CustomSerializer[Post](format => ( {
  case jObject: JObject =>
    implicit val fmt = format

    val title = (jObject \ "title").extract[String]
    val content = (jObject \ "content").extract[String]
    val datetimeStr = (jObject \ "datetime").extract[String]
    val datetime = PostSerializer.parseToZonedDateTime(datetimeStr)

    Post(title, content, datetime)
}, {
  case rssItem: Post =>
    ("title" -> rssItem.title) ~
      ("content" -> rssItem.content) ~
      ("datetime" -> PostSerializer.strFromZonedDateTime(rssItem.dateTime))
}
))

object PostSerializer {
  private def strFromZonedDateTime(t: ZonedDateTime): String =
    t.format(DateTimeFormatter.ISO_INSTANT)

  private def parseToZonedDateTime(t: String): ZonedDateTime = {
    Instant.parse(t).atZone(ZoneId.systemDefault())
  }
}
