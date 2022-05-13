package org.example.ch03

import java.security.InvalidParameterException

// 5월 11일 수요일

fun <T> joinToString(
    lists: List<T> = listOf(),
    separator: String = "",
    prefix: String = "",
    postfix: String
): String {
    return ""
}

class Person(vararg args: String, val name: String, var isMarried: Boolean)

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

fun printNumbers(vararg numbers: Int) {
    for (number in numbers) {
        println(number)
    }
}

//로컬 함수
class AnkiUser(val id: Int, val name: String, val address: String)

fun saveUser(user: AnkiUser) {
    fun validate(value: String, field: String) {
        if (value.isEmpty()) {
            throw InvalidParameterException("field: $field")
        }
    }
    validate(user.name, "name")
    validate(user.address, "address")

    when (TempEnum.YELLOW) {
        TempEnum.RED, TempEnum.YELLOW -> println("RED or YELLOW")
        TempEnum.BLUE -> println("BLUE")
    }
}

enum class TempEnum {
    RED, YELLOW, BLUE
}

fun call() {
    val of = setOf(1, 2, 3)
    saveUser(AnkiUser(1, "", ""))
}

//중위 호출
// 매개변수가 1개, fun 앞에  infix 키워드
//구조 분해 선언 !

fun max(a: Int, b: Int) = if (a > b) a else b


interface Clickable {
    fun click() //일반 추상 메서드
    fun showOff() = println("I'm clickable!")   // 디폴트 구현이 있는 메소드
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")

    fun showOff() = println("I'm focusable!")

}

class Button : Clickable, Focusable {
    override fun click() {
        println("I was clicked")
    }

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

}


fun main() {

    val click = Button()
    click.showOff()

    joinToString(listOf(1, 2, 3), prefix = "(", separator = ",", postfix = ")")

    val numbers = intArrayOf(1, 2, 3)
    printNumbers(*numbers)  // intArryaOf 배열 객 체에서 하나씩만 꺼내(펴서) printNumbers 함수를 호출한다.

    val listOf = listOf(1, 2, 3)
    val mapOf = mapOf(1 to "one", "2" to "two")

}






























































