val numbers = (1 to 10).toList
numbers


val n = 7
val numbers = (1 to n / 2 + 1).toList
val oddNumbers = (3 to n + 3).toList.filter(_ % 2 != 0)
val divideNums = numbers.zip(oddNumbers).flatMap(p => List(p._1, p._2))
val plusMinusesOrder = divideNums.foldLeft(List(1)) { (result, n) =>
  result :+ result.last + n
}

val pattern = List(1, 1, 2, 3, 5, 7, 11)
def addNext(pattern: List[Int]): List[Int]= {
  val n = pattern.length
  val numbers = (1 to n / 2 + 1).toList
  val oddNumbers = (3 to n + 3).toList.filter(_ % 2 != 0)
  val divideNums = numbers.zip(oddNumbers).flatMap(p => List(p._1, p._2))
  val plusMinusesOrder = divideNums.foldLeft(List(1)) { (result, n) =>
    result :+ result.last + n
  }

  val order = (1 to pattern.length).toList
  val patternOrder = (order zip pattern.reverse).toMap
  val last = order.foldLeft((0, (1, 1))) { (result, n) =>
    if (plusMinusesOrder.contains(n)) {
      result._2 match {
        case (1, 1) => (result._1 + patternOrder(n), (1, 0))
        case (1, 0) => (result._1 + patternOrder(n), (0, 0))
        case (0, 0) => (result._1 - patternOrder(n), (0, 1))
        case (0, 1) => (result._1 - patternOrder(n), (1, 1))
      }
    }
    else result
  }._1
  pattern :+ last
}
