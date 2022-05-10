package ch03.ex3_5_ExtensionProperties

// String 객체의 확장 프로퍼티
val String.lastChar: Char
    get() = get(length - 1)

// StringBuilder 의 확장 프로퍼티
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) {
        this.setCharAt(length - 1, value)
    }

fun main() {
    println("Kotlin".lastChar)

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)
}
