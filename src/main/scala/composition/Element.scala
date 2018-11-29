package composition

abstract class Element {
  def demo() = {
    println("Element implementation invoked")
  }

  def foo(): String = "foo"
}

final class ArrayElement extends Element {
  final override def demo(): Unit = {
    println("ArrayElement implementation invoked")
  }
}

class LineElement extends Element {
  final override def demo(): Unit = {
    println("LineElement implementation invoked")
  }
}

/* demo:

scala> class ExArrayElement extends ArrayElement
<console>:14: error: illegal inheritance from final class ArrayElement
class ExArrayElement extends ArrayElement
^

*/

object MainApp {
  def main(args: Array[String]): Unit = {
    val l = new LineElement()
    l.foo()

    def f() = "foo"

    // eta-expansion
    val g = f _
    val h = (a:Int) => 3
    val i = h.apply(_)
  }
}
