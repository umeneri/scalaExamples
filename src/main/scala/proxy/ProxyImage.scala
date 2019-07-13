package proxy

class ProxyImage(filename: String) extends Image {
  var image: RealImage = _

  override def displayImage(): Unit = {
    if (image == null) {
      image = new RealImage(filename)
    }

    image.displayImage()
  }
}
