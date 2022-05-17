package org.example.anki

class Person517 {

    companion object

}

fun Person517.Companion.JSONForm() {
    println("Hello, World")
}

class User517(val id: Int, val name: String, val address: String)

fun saveUser517(user: User517) {
    /*
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Address")
    }
    */
    fun validate(field: String, fieldName: String) {
        if (field.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
        }
    }

    validate(user.name, "name")
    validate(user.address, "address")
}

/*

class Button517 : Clickable517 {
    override fun click() {
        println("I'm Button517")
    }
}
*/

class Rectangle517(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

interface Clickable517 {
    fun click() //일반 추상 메서드
    fun showOff() = println("I'm clickable!")   // 디폴트 구현이 있는 메소드
}

interface Focusable517 {
    fun setFocus(b: Boolean) =
        println("I ${if (b) "got" else "lost"} focus.")//b의 값에 따라 got 또는 lost 가 나오도록 하라


    fun showOff() = println("I'm focusable!") // 디폴트 구현이 있는 메소드

}

class Button517 : Clickable517, Focusable517 {
    override fun click() {
        println("I was clicked")
    }

    override fun showOff() {
        super<Clickable517>.showOff()
        super<Focusable517>.showOff()
    }
}

interface Click517_2 {
    val nickname: String // 추상프로티티

    fun click(): String {
        return "Hello"
    }
}
/*

object 무명객 : Click517_2 {
    override fun click(): String {
        return "Hello"
    }
}
*/

fun forTest() {
    for (i in 10 downTo 1 step 2) {
        println(i)
    }
}

// class A
// Inner class A

class Person517_2(name: String, age: Int) {
    val name: String = name

    var age: Int = age

}

fun main() {
    Person517.JSONForm()
    saveUser517(User517(1, "ljihoon", "address"))
    Button517().click()
    Button517().showOff()
    forTest()
}

interface Person_517_3 {
    val nickname: String
}

class Temp private constructor()
// if (b)
