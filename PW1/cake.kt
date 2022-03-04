fun main() {
    val age = 24
    val layers = 5
    printCakeCandles(age)
    printCakeTop(age)
    printCakeBottom(age, layers)
}

//Функция печати верхушки торта
fun printCakeTop(age: Int) {
    repeat(age + 2) {
        print("=")
    }
    println()
}

//Функция печати свечей
fun printCakeCandles(age: Int) {
    print(" ")
    repeat(age) {
        print(",")
    }
    println()
    
    print(" ")
    repeat(age) {
        print("|")
    }
    println()
}

//Функция печати нижней части торта
fun printCakeBottom(age: Int, layers: Int) {
    repeat(layers) {
        repeat(age + 2) {
            print("@")
        }
        println()
    }    
}