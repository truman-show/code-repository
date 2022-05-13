package org.example.anki

import ch04.ex1_5_1_SealedClasses.Expr
import ch04.ex1_5_1_SealedClasses.Num
import ch04.ex1_5_1_SealedClasses.Sum

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

interface Clickable {
    fun click()
    fun showOff() {
        println("I'am clickable!")  // 디폴트 구현이 있는 메소드
    }
}

class Button : Clickable {  // : 을 이용하여 상속 과 구현을
    override fun click() {
        super.showOff()
    }

}

// 코틀린 인터페이스 안에는 추상메서드 뿐만 아니라 구현이 있는 메소드도 정의할 수 있다
// 구조 분해 선언
// 커스텀 게터
// override

fun eval(e: Expr): Int = when (e) {
    is Num -> e.value
    is Sum -> eval(e.right) + eval(e.left)
    else -> throw IllegalArgumentException("Unknown expression")
}


fun joinToString() {

}


fun main() {
    test()
}

fun test() {
    // No cloze 2 found on card. Please either add a cloze deletion, or use the Empty Cards tool.
    val car = Car(manufacturer = "", "그랜저")
    val (manufacturer1111, model) = car
    println(manufacturer1111)
    println(model)
}


data class Car(
    val manufacturer: String = "디폴트 값",
    val model: String
)