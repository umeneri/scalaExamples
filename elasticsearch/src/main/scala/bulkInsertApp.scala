import com.sksamuel.elastic4s.http.index.CreateIndexResponse
import com.sksamuel.elastic4s.http.{ElasticClient, ElasticProperties, Response}

object bulkInsertApp extends App {
  import com.sksamuel.elastic4s.http.ElasticDsl._

  val client = ElasticClient(ElasticProperties("http://localhost:9200"))

  val r: Response[CreateIndexResponse] = client.execute {
    indexInto("accounts") {

    }
  }.await

  println(r)

  client.close()
}
