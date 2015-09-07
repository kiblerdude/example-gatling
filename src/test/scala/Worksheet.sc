object Worksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val throughputs = List(100, 50, 5)              //> throughputs  : List[Int] = List(100, 50, 5)
  
  val total = throughputs.foldLeft(0)((t, i) => t+i).toDouble
                                                  //> total  : Double = 155.0
  val percentages = throughputs.map( x => x / total )
                                                  //> percentages  : List[Double] = List(0.6451612903225806, 0.3225806451612903, 0
                                                  //| .03225806451612903)
}