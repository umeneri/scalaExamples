import com.sksamuel.elastic4s.RefreshPolicy
import com.sksamuel.elastic4s.http.{ElasticClient, ElasticProperties}
import com.sksamuel.elastic4s.http.Response
import com.sksamuel.elastic4s.http.index.CreateIndexResponse
import com.sksamuel.elastic4s.http.search.SearchResponse

object createMapping extends App {
  // you must import the DSL to use the syntax helpers
  import com.sksamuel.elastic4s.http.ElasticDsl._

  val client = ElasticClient(ElasticProperties("http://localhost:9200"))

//  val r: Response[CreateIndexResponse] = client.execute {
//    createIndex("blog").mappings(
//      mapping("contents").fields(
//        textField("title")
//      )
//    )
//  }.await
//
//  println(r)

  client.execute {
    indexInto("blog", "contents") fields {
      "title" -> "test"
    }
  }

//  client.execute {
//    bulk(
//      indexInto("myindex" / "mytype").fields("country" -> "Mongolia", "capital" -> "Ulaanbaatar"),
//      indexInto("myindex" / "mytype").fields("country" -> "Namibia", "capital" -> "Windhoek")
//    ).refresh(RefreshPolicy.WaitFor)
//  }.await

//  val response: Response[SearchResponse] = client.execute {
//    search("myindex").matchQuery("capital", "ulaanbaatar")
//  }.await

  // prints out the original json
//  println(response.result.hits.hits.head.sourceAsString)

  client.close()



}
