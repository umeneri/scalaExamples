package future

import org.scalatest.AsyncFlatSpec

class HelloFutureWithAsyncSpec extends AsyncFlatSpec {
  "hello method with async assert" should "return string 'hello!'" in {
    HelloFuture.hello() map { result =>
      println("ok")
      assert(result == "hello!")
    }
  }
}
