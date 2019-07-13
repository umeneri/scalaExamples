package proxy

object ProxyExample extends App {
  val image1 = new ProxyImage("10mb-photo-1")
  val image2 = new ProxyImage("10mb-photo-2")

  image1.displayImage()
  image1.displayImage()
  image2.displayImage()
  image2.displayImage()
  image1.displayImage()

}
