//Бросок кубика
class Dice(val numSides: Int, val color: String) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}

//Подбрасывание монеты
class Coin {
    fun flip(): String {
        val resultFlip = (1..2).random()
        return (if (resultFlip == 1) "Heads" else "Tails")
    }
}

fun main() {
	val myFirstDice = Dice(6, "Red")
	println("Your ${myFirstDice.color} ${myFirstDice.numSides} sided dice rolled ${myFirstDice.roll()}!")
    
    val mySecondDice = Dice(20, "Green")
    println("Your ${mySecondDice.color} ${mySecondDice.numSides} sided dice rolled ${mySecondDice.roll()}!")

	val firstCoin = Coin()
    println("Dropped ${firstCoin.flip()}")
}