package org.example.anki

// internal
// Comparable

interface User520_interface {
    val email: String
    val nickname: String
        get() = email.substringBefore('@') // 프로퍼티에 뒷받침하는 필드가 없다. 대신 매번 결과를 계산해 돌려준다.
}

// super<Clickable>.showOff

class C {
    companion object CompanionName {
        fun test() {
            println("Hello, world")
        }
    }
}

fun main() {
    C.CompanionName.test()

}

open class User520_class(
    //val name: String, val age: Int
) {

    constructor(name: String) : this(name, "닉네임")

    constructor(name: String, nickname: String) : this()


    private fun test() {
        println("private method")
    }

    fun test2() {

    }
}

/*

class Buttonaa() {
    constructor(ctx: String) : this(ctx, "이지훈")

    constructor(name: String, nickname: String) : this()
}
*/


fun User520_class.method() {
    //this.test() 호출 못한다. 확장함수가 캡슐화를 꺠지는 않는다
    this.test2()
}

var calCount: Int = 0   // 기본적으로 최상위 프로퍼티도 다른 모든 프로퍼티 처럼 접근자 메소드를 통해 자바 코드에 노출된다.

/*

class MyButton : View {
    constructor(ctx: Context) : this(ctx, MY_STYLE) {
        //..
    }

    constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr) {
        //...
    }
}

*/

class TwitterUser520(val name: String) : User520_class(name)


class Outer520 {

    inner class Innter520 {
        fun test() {
            this@Outer520
        }
    }

}
































