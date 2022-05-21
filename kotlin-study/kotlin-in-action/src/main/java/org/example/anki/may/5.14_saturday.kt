package org.example.anki

import org.junit.runner.manipulation.Ordering.Context


fun <T> Collection<T>.joinToString5_14(
    separator: String = ";",
    prefix: String = "(",
    postfix: String = ")"
): String {
    println(separator)
    return ""
}

fun when5_14() {

    val temp = 3
    when (temp) {
        in 1..3 -> println("1~3 포함 : $temp")
        !in 1..3 -> println("1~3 미포함 : $temp")
    }
}

// val 은 파라미터에 상응하는 프로퍼티가 생성된다는 뜻
open class User5_14(
    val name: String,    // 생성자 파라미터에 대한 디폴트 값을 제공한다
    val isSubscribed: Boolean = true
) {
    private val accessTest = "hello"

}

class TwitterUser514(nickname: String) : User5_14(nickname), Button514


fun User5_14.test() {
    println(name)
    println(isSubscribed)
    //println(accessTest) //확장함수에서는 클래스 내부에서만 사용할 수 있는 비공개(private) 멤버나 보호된(protected) 멤버를 사용할 수없다
}


// final : 상속 불가
// open : 상속 가능
// abstract : 구현 필수
// override : override 중

interface Button514 {
    val absVal: String
        get() = "초기값"
}

open class View {
    constructor(ctx: Context)

    constructor(name: String, temp: String)

    val map = mapOf(1 to 1, 2 to 2)

}

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
class Buttonaa() {
    constructor(ctx: String) : this(ctx, "이지훈")

    constructor(name: String, nickname: String) : this()
}

class A

class B {
    val name = "이지훈"

    inner class C {
        fun test() {

            println(this@B.name)
        }
    }
}


interface User514_interfase {
    val email: String
    val nickname: String
        get() = email.substringBefore('@') // 프로퍼티에 뒷받침하는 필드가 없다. 대신 매번 결과를 계산해 돌려준다.
}

//varage
//값을 저장하는 프로퍼티와 커스텀 접근자에서 매번 값을 계산하는 프로퍼티


class User514(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println(
                """
            Address was changed for $name:
            "$field" -> "$value".""".trimIndent()
            )
            field = value
        }
}


// is 로 스마트 캐스트 지원
fun main() {
    val lists = arrayListOf<Int>(1, 2, 3)
    lists.joinToString5_14(separator = ",")
    when5_14()

    TwitterUser514("닉네임")

    val user514 = User514("Alice")
    user514.address = "서울시 강북구"


}

class aa(override val email: String) : User514_interfase


class Person(name: String, age: Int) {
    /*
    val name = name
        get() {
            return field
        }

    var age = age
        set(value: Int) {
            field = value
        }
        get() {
            return field
        }
    */
    fun test() {
        val listOf = listOf(1, 2, 3)
        val mapOf = mapOf(1 to "one")
    }
}


class Person2(name: String, age: Int) {
    val name = name

    var age = age

}









































