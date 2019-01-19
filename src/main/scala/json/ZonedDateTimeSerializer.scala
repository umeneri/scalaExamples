package json

import org.json4s.{DefaultFormats, JValue}
import org.json4s.native.JsonMethods.parse

object ZonedDateTimeSerializer extends App {
  val jsonString =
    """
      |{
      |  "title": "Json4sの使い方",
      |  "content": "Json4sの使い方は...このようになってます",
      |  "datetime": "2019-01-12T03:15:00Z"
      |}
    """.stripMargin

  val json: JValue = parse(jsonString)

  implicit val formats = DefaultFormats + new PostSerializer()
  val post = json.extract[Post]

  println(post)
}


