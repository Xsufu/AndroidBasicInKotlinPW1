fun main() {
    // Список
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    println("list:   ${numbers}")
    println("sorted: ${numbers.sorted()}")
    
    // Набор
    val setOfNumbers = numbers.toSet()
	println("set:    ${setOfNumbers}")
    
    // Проверка равенства наборов и поиск
    val set1 = setOf(1,2,3)
	val set2 = mutableSetOf(3,2,1)
    println("$set1 == $set2: ${set1 == set2}")
    println("contains 7: ${setOfNumbers.contains(7)}")
    
    // Инициализация коллекции
    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )
    
    // Добавление элементов
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51
    
    // Добавление копии ключа
    peopleAges["Fred"] = 31
    
    // Печать коллекции
    println("$peopleAges \n")
    
    // Цикл forEach
    println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", ") )
    
    // Фильтр (имя короче 4-ёх символов)
    val filteredNames = peopleAges.filter { it.key.length < 4 }
	println("Отфильтрованная коллекция: $filteredNames\n")
    
    // Лямбда-функции
     
    // Полная запись
    // val triple: (Int) -> Int = { a: Int -> a * 3 }
    // Альтернативный вид
    val triple: (Int) -> Int = { it * 3 }
    println(triple(5))
    
    //Функции высшего порядка
    val peopleNames = listOf("Fred", "Ann", "Barbara", "Joe")
    println(peopleNames.sorted())
    println(peopleNames.sortedWith { str1: String, str2: String -> str1.length - str2.length })
}