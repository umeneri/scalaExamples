package mapconversion

object MapConversion extends App {
  val newMap = Map("1" -> 1, "2" -> 2, "3" -> 3)

  val map1 = newMap.map {
    case (_, value) => (Math.random(), value)
  }

  val map2 = newMap.map {
    case (_, value) => Math.random() -> value
  }


  val list1 = newMap.map {
    case (_, value) => value
  }

  println(map1) // => Map(0.15985975180002765 -> 1, 0.6619101600969522 -> 2, 0.18256060363818238 -> 3)
  println(map2) // => Map(0.31876372630036387 -> 1, 7.773814391255351E-4 -> 2, 0.2837391028402594 -> 3)
  println(list1) // => List(1, 2, 3)
}
