package composition

abstract class Element {
  val space = " "

  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0 || contents.length == 0) 0 else contents.map(_.length).max

  def demo(): Unit = {
    println("Element implementation invoked")
  }

  def above(that: Element): Element = {
    val w = this.width.max(that.width)
    val this2 = this.widen(w)
    val that2 = that.widen(w)

    Element.elem(this2.contents ++ that2.contents)
  }

  def beside(that: Element): Element = {
    val h = this.height.max(that.height)
    val this2 = this.heighten(h)
    val that2 = that.heighten(h)

    Element.elem(
      for {
        (line1, line2) <- this2.contents.zip(that2.contents)
      } yield line1 + line2
    )
  }

  def widen(w: Int): Element = {
    if (w <= width) this
    else {
      val newContents = contents.map(content => {
        val left = ((w - content.length) / 2.0).ceil.toInt
        val right = ((w - content.length) / 2.0).floor.toInt
        space * left + content + space * right
      })
      Element.elem(newContents)
    }
  }

  def heighten(h: Int): Element = {
    if (h <= height) this
    else {
      val char = space.charAt(0)
      val padding = ((h - height) / 2.0).ceil.toInt
      val top = Element.elem(char, width, padding)
      val bottom = Element.elem(char, width, padding)
      top above this above bottom
    }
  }

  override def toString: String = contents.mkString("\n")

}

object Element {
  val space = " "

  private case class ArrayElement(contents: Array[String]) extends Element {
    final override def demo(): Unit = {
      println("ArrayElement implementation invoked")
    }
  }

  private case class LineElement(s: String) extends Element {
    val contents = Array(s)

    override def height: Int = 1

    override def width: Int = s.length

    final override def demo(): Unit = {
      println("LineElement implementation invoked")
    }
  }

  private case class UniformElement(
                                       ch: Char,
                                       override val width: Int,
                                       override val height: Int
                                   ) extends Element {
    private val line = ch.toString * width

    override def contents: Array[String] = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): Element = {
    ArrayElement(contents)
  }

  def elem(chr: Char, width: Int, height: Int): Element = {
    UniformElement(chr, width, height)
  }

  def elem(line: String): Element = {
    LineElement(line)
  }
}


/* demo:
scala> class ExArrayElement extends ArrayElement
<console>:14: error: illegal inheritance from final class ArrayElement
class ExArrayElement extends ArrayElement
^
*/

object Main extends App {
  val array1 = Element.elem(Array("Oh!", "hello", "world!!"))
  val array2 = Element.elem(Array("and you!!"))

  println(array1)
  println(array2)

  println("===========================")
  val test1 = array1.above(array2)
  println(test1)

  println("===========================")
  val test2 = array1.beside(array2)
  println(test2)

  println("===========================")
  val t1 = Element.elem('+', 1, 4)
  val t2 = Element.elem('+', 1, 5)

  println(t1.beside(t2))

  println("===========================")
  val s1 = Element.elem('+', 2, 1)
  val s2 = Element.elem('+', 1, 1)

  println(s1.above(s2))
}

