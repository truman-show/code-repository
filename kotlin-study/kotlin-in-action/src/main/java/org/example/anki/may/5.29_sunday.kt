package org.example.anki.may

//
interface User529 {
    val nickname: String    //User529 인터페이스를 구현하는 클래스는 nickname 의 값을 얻을 수 있는 방법을 제공해야한
}


fun main(args: Array<String>) {
    val numbers = setOf(1, 14, 2)
    println(numbers.maxByOrNull { it })

    var email: String? = "ljihoon@example.com"

    email?.let { sendEmailTo(it) }

    email = null
    email?.let { sendEmailTo(email) }
    println("Hello, World")
//    email.substringAfterLast()
    C529.func()
}

fun strLenSafe(s: String?): Int {
    return s?.length ?: 0
}
/*

>>> println(strLenSafe("abe"))
3
>>> println(strLenSafe(null))
0*/

class Rectangle529(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}

interface Clickable_529 {
    fun click() //일반 추상 메서드
    fun showOff() = println("I'm clickable!")   // 디폴트 구현이 있는 메소드
}

interface Focusable_529 {
    fun setFocus(b: Boolean) =
        println("I ${if (b) "got" else "lost"} focus.")//b의 값에 따라 got 또는 lost 가 나오도록 하라


    fun showOff() = println("I'm focusable!") // 디폴트 구현이 있는 메소드

}

class Button529 : Clickable_529, Focusable_529 {
    override fun click() {
        println("I was clicked")
    }

    override fun showOff() {
        super<Clickable_529>.showOff()
        super<Focusable_529>.showOff()
    }

}

//C라는 클래스 안에 동반 객체가 있고 그 동반 객체(C.Companion) 안에 func를 정의하면 외부에서는 func()를 C.func()로 호출할 수 있다.
//코드로 작성해봐라

class C529 {
    companion object {
        fun func() {

        }
    }
}

class Person529 {
    companion object
}
/*

fun Person529.Companion.fromJSON(): Person529 {

}
*/

class Temp529 {
    //val name:String, val nickName:String
    var name: String
    val nickName: String

    constructor(name: String) : this(name, "jihoon")

    constructor(name: String, nickName: String) {
        this.name = name
        this.nickName = nickName
    }
}
/*

class MyButton : View {  // 클래스 헤더에 있는 클래스 이름뒤에 괄호가 없다.
    constructor(ctx: Context) : super(ctx) { // 상위 클래스의 생성자를 호출한다.
        //[...]
    }

}
*/

class TwitterUser531(nickName: String) : User531(nickName)

open class User531(val nickName: String)

class Outer531 {
    inner class Inner {

        fun getOuterReference(): Outer531 = this@Outer531
    }
}
















