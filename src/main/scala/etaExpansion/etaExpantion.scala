package etaExpansion

class etaExpantion {
}

object MainApp {
  def main(args: Array[String]): Unit = {
    def f() = "foo"

    // eta-expansion
    val g = f _
    val h = (a: Int) => 3
    val i = h.apply(_)
  }
}


