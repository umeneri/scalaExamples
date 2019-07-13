package proxy

class RealImage(filename: String) extends Image {
  println(s"loading $filename")

  override def displayImage(): Unit = {
    println(s"display $filename")
  }
}
