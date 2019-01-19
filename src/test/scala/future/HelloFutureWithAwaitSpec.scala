package future

import org.scalatest.FlatSpec

import scala.concurrent.Await
import scala.concurrent.duration._

class HelloFutureWithAwaitSpec extends FlatSpec {
  "hello method" should "return string 'hello!'" in {
    val result = Await.result(HelloFuture.hello(), 500 millis)
    assert(result == "hello!")
  }
}
