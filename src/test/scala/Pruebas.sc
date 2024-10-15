import MatchingProblem._

val pilot: Vector[Vector[Int]] = Vector(Vector(2, 3, 1, 1), Vector(1, 1, 4, 3), Vector(1, 2, 3, 4), Vector(2, 3, 2, 1))
val navig: Vector[Vector[Int]] = Vector(Vector(4, 1, 3, 2), Vector(4, 2, 3, 1), Vector(1, 1, 1, 4), Vector(3, 2, 3, 3))

// Casos de prueba: Emparejamientos de un piloto
matchByElement(2, 5)
matchByElement(3, 5)
matchByElement(4, 6)
matchByElement(5, 7)
matchByElement(7, 9)

// Casos de prueba: Emparejamientos posibles de todos los pilotos
matchsByElements(1)
matchsByElements(2)
matchsByElements(3)
matchsByElements(4)
matchsByElements(5)

// Casos de prueba: Posibles emparejamientos
possibleMatchings(1)
possibleMatchings(2)
possibleMatchings(3)
possibleMatchings(4)
possibleMatchings(5)

// Casos de prueba: Emparejamientos válidos
matchings(1)
matchings(2)
matchings(3)
matchings(4)
matchings(5)

// Casos de prueba: Calculando los pesos de los emparejamientos válidos
weightedMatchings(2, pilot, navig)
weightedMatchings(3, pilot, navig)
weightedMatchings(4, pilot, navig)

// Casos de prueba: Calculando el mejor emparejamiento
bestMatching(2, pilot, navig)
bestMatching(3, pilot, navig)
bestMatching(4, pilot, navig)

