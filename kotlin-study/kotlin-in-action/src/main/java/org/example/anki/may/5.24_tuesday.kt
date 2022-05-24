package org.example.anki.may

import org.example.anki.Color

fun max(a: Int, b: Int): Int = if (a > b) a else b


/*
class Person(val name: String){
    companion object Loader {
        fun fromJSON(jsonText: String) : Person = ...
    }
}
*/

fun test() {
    val red = Color.RED
    when (red) {
        Color.RED, Color.BLUE -> println("red or blue")
    }
}

interface Button524 {
    fun button()
}

/*

object : Button524 {
    override fun button() {
        println("OK Clicked")
    }
}
*/

fun main() {
    val click = Button()
    click.showOff()

    val hashMapOf = hashMapOf(1 to "one")
    val c524 = C524()

    val strings = listOf("first", "second", "fourteenth")
    strings.last()

}

fun <T> joinToString(collections: Collection<T> = listOf(), name: String = "") {

}

// public 어디서든 접근이 가능하다
// internal 같은 모듈에서만 접근이 가능하다
// protected 하위 클래스에서 만 접근가능하다
// private 접근이 불가하다

class C524 {
    companion object Temp {
        fun funCompannion() {
            println("222")
        }
    }
}


class user524 {
    constructor(name: String) : this(name, 1)

    constructor(name: String, age: Int)
}

// 구조 분해 선언


class Rectangle524(val height: Int, val width: Int) {
    val Rectangle: Boolean
        get() = height == width

}

// 값을 저장하는 프로퍼티, 커스텀 접근자에서 매번 값을 계산하는 프로퍼티

interface Clickable {
    fun click() //일반 추상 메서드
    fun showOff() {
        println("showOff")
    }
}

interface Focusable {
    fun setFocus(b: Boolean) =
        println("I ${if (b) "got" else "lost"} focus.")//b의 값에 따라 got 또는 lost 가 나오도록 하라


    fun showOff() = println("I'm focusable!") // 디폴트 구현이 있는 메소드

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




