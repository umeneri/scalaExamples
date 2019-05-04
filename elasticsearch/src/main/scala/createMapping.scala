import com.sksamuel.elastic4s.http.index.CreateIndexResponse
import com.sksamuel.elastic4s.http.{ElasticClient, ElasticProperties, Response}

object createMapping extends App {
  import com.sksamuel.elastic4s.http.ElasticDsl._

  val client = ElasticClient(ElasticProperties("http://localhost:9200"))

  val r: Response[CreateIndexResponse] = client.execute {
    createIndex("blog").mappings(
      mapping("contents").fields(
        textField("title")
      )
    )
  }.await

  println(r)

  client.close()
}
