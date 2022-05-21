@file:JvmName("JvmNameStudy")

package org.example.anki

// 프로퍼티와 메소드가 있는 enum 클래스 선언하기

enum class Color {
    BLUE, RED;

    fun checkColor(): Boolean {
        return when (this) {
            BLUE -> true
            RED -> true
        }
    }
}

enum class Color2(
    val r: Int, val g: Int, val b: Int
) {
    RED(255, 0, 0), ORANGE(255, 165, 0);

    fun rgb() = (r * 256 + g) * 256 + b
}

// !in


fun main() {
    println(Color.BLUE.checkColor())
    //temp()

    for (i in 1 until 10) {
        println(i)
    }

}

abstract class Animated {
    abstract fun animate()
}
// final : 상속 불가 -> 클래스 멤버의 기본 병경자
// open : 상속 허용 -> 오버라이드할 수 있음
// abstract : 추상 클래스 -> 반드시 오버라이드해야 함
// override : 오버라이드  -> 상위 클래스나 상위 인스턴스의 멤버를 오버라이드 하는 중


// public : 어디서든 접근 가능
// internal : 패키지 전용 가시성 대안, 모듈 내부에서만 볼 수 있음
// protected : 하위 클래스에서만 접근 가능
// private : 같은 클래스 안에서만 볼 수 있다

/*

fun temp() {
    for (i in 10 downTo 1 step 2) {
        println(i)
    }
}
*/

// final : 기본 상속 제어 변경자 -> 상속 불가
// open : 상속 가능
//abstract : 강제 상속 필수
// override : 오버라이드 구현

class Outer {
    inner class Inner {
        fun getOuterReference(): Outer {
            return this@Outer
        }
    }
}

// person.isMarried = false
//


open class OuterClass {
    fun test() {

    }
}
//sealed

class User(val nickname: String)