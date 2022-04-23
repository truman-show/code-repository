package org.example.ch02

class Rectangle(private val height: Int, private val width: Int) {
    // 중괄호 안에서 프로퍼티 및 커스텀 접근자를 추가할 수 있다.
    val isSquare: Boolean get() = height == width  // 클래스의 특성을 표현할때는 프로퍼티를 사용하자. 프로퍼티에는 특성이라는 뜻이 있다.

    fun isSquareFun(): Boolean {    // 함수 또한 추가 가능하
        return height == width
    }

}

fun main() {
    val rectangle1 = Rectangle(41, 43)
    val rectangle2 = Rectangle(41, 41)
    val rectangle3 = Rectangle(41, 41)
    println(rectangle1.isSquare)
    println(rectangle2.isSquare)
    println(rectangle3.isSquareFun())
}
