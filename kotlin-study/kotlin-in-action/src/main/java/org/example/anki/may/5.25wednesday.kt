package org.example.anki.may

/*
class User525 constructor(_nickname: String) {    // 파라미터가 하나만 있는 주 생성자
    val nickname: String

    init {    // 초기화 블록
        nickname = _nickname
    }
}
*/


interface User525 {
    val email: String
    val nickname: String
        get() = email.substringBefore('@') // 프로퍼티에 뒷받침하는 필드가 없다. 대신 매번 결과를 계산해 돌려준다.
}


fun main() {
    val listOf = arrayListOf(1, 2, 3)
    C525.func()
    C525.C5252().test()

    println("Kotlin".lastChar525)

    for (i in 100 downTo 1 step 2) {
        println(i)
    }

}

val String.lastChar525: Char
    get() {
        return get(this.lastIndex)
    }

class C525 {
    companion object Companion {
        fun func() {

        }
    }

    class C5252 {
        fun test() {
            func()
        }
    }

    inner class C5253 {
        fun test() {
            this@C525
        }
    }
}
