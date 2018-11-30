package types

object ErrorHandling extends App {

  def errorIfNeeded(n: Int): Int = {
    if (n > 0) {
      return 0
    } else
    throw new Error("throw exception!");
  }

  val h = errorIfNeeded(-1)
  println(h)

}
