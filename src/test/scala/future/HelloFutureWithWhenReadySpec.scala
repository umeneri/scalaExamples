package future

import org.scalatest.FlatSpec
import org.scalatest.concurrent.ScalaFutures

class HelloFutureWithWhenReadySpec extends FlatSpec with ScalaFutures {
  "hello method with whenReady" should "return string 'hello!'" in {
    whenReady(HelloFuture.hello()) { result =>
      assert(result == "hello!")
    }
  }
}
