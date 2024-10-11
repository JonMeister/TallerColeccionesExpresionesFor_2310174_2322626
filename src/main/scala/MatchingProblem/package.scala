package object MatchingProblem {

  type Match = (Int,Int)
  type Matching = List[Match]
  type Preferences = Vector[Vector[Int]]

  def matchByElement(numPiloto : Int, cantidadCopilotos : Int) : Matching = {

    val posibleCombinationsPerPilot = for(copiloto <- 1 to cantidadCopilotos) yield (numPiloto,copiloto)

    posibleCombinationsPerPilot.toList

  }

  def matchsByElements(NumberPilotCopilot : Int) : List[Matching] = {

    val allPosibleCombinations = for(piloto <- 1 to NumberPilotCopilot) yield
      matchByElement(piloto,NumberPilotCopilot)

    allPosibleCombinations.toList

  }

  def possibleMatchings(n : Int) : List[Matching] = {

    val li: List[Matching] = matchsByElements(n)

    li.foldLeft(List(List.empty[(Int,Int)])) { (acc, elem) => {
      for {
        p <- acc
        c <- elem } yield p ++ List(c)
    }
    }
  }

  def matchings(n : Int) : List[Matching] = {

    def auxCompare(li : List[Match]) : Boolean = {
      val secondsPositions : List[Int] = li.map(_._2).distinct

      if(li.length == secondsPositions.length) true
      else false
    }

    def iterative(li : List[Matching]) : List[Matching] = {
      val retorno = for{

        l <- li
        if auxCompare(l)

      }yield l

      retorno
    }

    iterative(possibleMatchings(n))

  }

  def weightMatchings(n : Int, pilotPrefs : Preferences, navigPrefs : Preferences) : List[(Matching,Int)] = {

    def calcWeightOneList(li : List[Match]) : Int = {
      val prodList = for{

        i <- li

      } yield pilotPrefs(i._1-1)(i._2-1) * navigPrefs(i._2-1)(i._1-1)

      prodList.sum
    }

    def iterative(li : List[Matching]) : List[(Matching,Int)] = {

      for {
        i <- li
      } yield (i, calcWeightOneList(i))

    }

    iterative(matchings(n))

  }

  def bestMatching(n : Int, pilotPrefs : Preferences, navigPrefs : Preferences) : (Matching,Int) = {
    val allweights = weightMatchings(n, pilotPrefs, navigPrefs)

    allweights.foldLeft(allweights.head){
      (acc,elem) => {
        if(elem._2 > acc._2) elem
        else acc
      }
    }

  }

  //val pilot: Vector[Vector[Int]] = Vector(Vector(2, 3, 1, 1), Vector(1, 1, 4, 3), Vector(1, 2, 3, 4), Vector(2, 3, 2, 1))
  //val navig: Vector[Vector[Int]] = Vector(Vector(4, 1, 3, 2), Vector(4, 2, 3, 1), Vector(1, 1, 1, 4), Vector(3, 2, 3, 3))
}
