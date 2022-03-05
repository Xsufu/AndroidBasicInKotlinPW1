/**
* Программа, реализующая классы для различных видов жилья.
* Демонстрирует, как:
* Создать иерархию классов, переменные и фукнкции с наследованием,
* абстрактный класс, переопределение и частные или общедоступные переменные.
*/

import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
    val squareCabin = SquareCabin(6, 50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 15.5)
    
    with(squareCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
	}
    
    with(roundHut) {
        println("\nRound Hut\n=========")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Floor area: %.2f".format(floorArea()))
        println("Carpet size: %.2f".format(calculateMaxCarpetSize()))
	}
    
    with(roundTower) {
        println("\nRound Tower\n===========")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
	}
}

/**
* Определяет свойства, похожие для всех типов жилых помещений.
* Все жилища имеют площадь, но её расчёт зависит от подкласса
* Проверка и получение комнаты реализованы здесь, 
* так как они одинаковы для всех подклассов
*
*@param residents - текущее количество жильцов
*/ 
abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int
    
    /**
     * Проверяет, есть ли место для нового жильца
     * 
     * @return true, если место есть и false, если нет
     */ 
    fun hasRoom(): Boolean {
        return residents < capacity
    }
    
    /**
     * Вычисляет площадь жилища
     * Реализовано в подклассах, определяющих форму
     * 
     * @return площадь жилища
     */ 
    abstract fun floorArea(): Double
    
    /**
     * Сравнивает текущее количество жителей с вместимостью.
     * Если место есть - увеличивает количество жителей.
     * Выводит результат.
     */ 
    fun getRoom() {
    if (capacity > residents) {
        residents++
        println("You got a room!")
    } else {
        println("Sorry, at capacity and no rooms left.")
    }
}
}

/**
* Жилище квадратной формы
* 
* @param residents - текущее количество жителей
* @param length - длина стен
*/ 
class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    override val buildingMaterial = "Wood"
    override val capacity = 6  
    
    /**
     * Вычисляет площадь квадратного помещения
     * 
     * @return площадь жилья
     */ 
    override fun floorArea(): Double {
        return length * length
    }
}

/**
* Жилище круглой формы
* 
* @param residents - текущее кол-во жителей
* @param radius - радиус помещения
*/ 
open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4
    
    /**
     * Вычисляет площадь круглого помещения
     * 
     * @return площадь жилища 
     */ 
    override fun floorArea(): Double {
    	return PI * radius * radius
	}
    
    /**
     * Вычисляет максимальную площадь квадратного ковра
     * 
     * @return площадь ковра
     */ 
    fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }
}

/**
* Круглая башня с несколькими этажами
* 
* @param residents - текущее кол-во жителей
* @param radius - радиус помещения
* @param floors - количество этажей
*/ 
class RoundTower(residents: Int,
                 radius: Double,
                 val floors: Int = 2,
                ) : RoundHut(residents, radius)  {
    override val buildingMaterial = "Stone"
    
    //Вместимость зависит от количества этажей
    override val capacity = 4 * floors
    
    /**
     * Вычисляет площадь башни с несколькими этажами
     * 
     * @return площадь жилья
     */ 
    override fun floorArea(): Double {
    	return super.floorArea() * floors
	}
}