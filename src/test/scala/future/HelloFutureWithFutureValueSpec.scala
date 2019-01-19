package future

import org.scalatest.FlatSpec
import org.scalatest.concurrent.ScalaFutures

class HelloFutureWithFutureValueSpec extends FlatSpec with ScalaFutures {
  "hello method with futureValue" should "return string 'hello!'" in {
    assert(HelloFuture.hello().futureValue == "hello!")
  }
}
