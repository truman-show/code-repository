package org.example.anki

import javax.naming.Context

open class View5_15 {

    val value: String

    constructor(conValue: String) {
        value = conValue
    }
}

class MyButton_5_15 : View5_15 {
    constructor(ctx: Context, value: String) : super(value)
}

interface Clicakable_5_15 {
    fun click()
}

fun test_5_15() {
    val i = 3
    when (i) {
        in 1..3 -> println(i)
        !in 1..3 -> println(i)
    }
}

fun main() {
    val view515 = View5_15("hello")
    println(view515.value)
    test_5_15()

    println("Kotlin".lastChar5_15)
}

val String.lastChar5_15: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) {
        this.setCharAt(length - 1, value)
    }
