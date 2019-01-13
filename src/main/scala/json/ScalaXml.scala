package json

import org.json4s.JValue
import org.json4s.Xml.toJson

import scala.xml.Elem

object ScalaXml extends App {
  val xml: Elem =
    <body>
      <h1>title</h1>
      <div>
        <p>content</p>
      </div>
    </body>

  val json: JValue = toJson(xml)

  println(json) // JValue形式
}
