fun main() {
    // Инициализируем список слов
	val words = listOf("about", "acute", "awesome", "balloon", 
                       "best", "brief", "class", "coffee", "creative")
    
    // Филтруем слова, начинающиеся с "b"
    // Перемешиваем слова (shuffled())
    // Выводим только два (take(2))\
    // Сортируем слова
    var filteredWords = words.filter { it.startsWith("b", ignoreCase = true) }
        .shuffled()
        .take(2)
        .sorted()
	println(filteredWords)
    
    // Выводим слуйчайное слово на букву "c"
    filteredWords = words.filter { it.startsWith("c", ignoreCase = true) }
        .shuffled()
        .take(1)
    println(filteredWords)
}