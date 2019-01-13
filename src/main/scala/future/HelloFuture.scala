package future

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object HelloFuture {

  def hello(): Future[String] = {
    Future {
      Thread.sleep(10 * 1000)
      "hello!"
    }
  }
}
