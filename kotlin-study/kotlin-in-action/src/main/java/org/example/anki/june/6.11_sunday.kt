package org.example.anki.june

import ch04.ex4_2_2_CompanionObjects1.getFacebookName
import org.example.anki.lastChar
import javax.naming.Context

// mapOf<String, Any> null을 허용하지 않는데 널이 넘어온다?
// Spring 통합 테스트용 애노테이션, 모든 빈을 스프링 컨텍스트에 등록하여 테스트를 진행한다
// ResponseEntityExceptionHandler 설명
// 스프링에서 제공하는 예외들을 미리 등록해둔 클래스
// 구현하면 등록해둔 예외 핸들러를 사용가능하다 단 body 값은 null이니 구현시 필요하다면 오버라이드를 해야한다
// WebMvcTest, DataJdbcTest ...


val String.lastChar: Char
    get() = get(lastIndex)

var StringBuilder.lastChar: Char
    get() = get(lastIndex)
    set(value) = this.setCharAt(length - 1, value)


class User(val id: Int, val name: String, val address: String)

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id: empty $fieldName")
        }
        validate(name, "Name")
        validate(address, "Address")
    }
}

fun saveUser(user: User) {
    user.validateBeforeSave()
}


/*
    fun saveUser(user:User){
        if(user.name.isEmpty()){
            throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
        }
        if(user.address.isEmpty()){
            throw IllegalArgumentException("Can't save user ${user.address}: empty Name")
        }
    }
    */

/*

interface User {
    val email: String   // 추상 프로퍼티
    val nickname: String
        get() = email.substringBefore('@') // 프로퍼티에 뒷받침하는 필드가 없다. 대신 매번 결과를 계산해 돌려준다.
}

class UserImpl(private val _email: String) : User {
    override val email: String
        get() = _email
}

val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) {
        this.setCharAt(length - 1, value)
    }

fun <T> Collection<T>.joinToString(separator: String, prefix: String, postfix: String): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

class A {
    val name: String = ""

    inner class B {
        fun temp() {
            this@A.name
        }
    }
}
*/

fun strLenSafe(s: String?): Int {
    return s?.length ?: 0
}
/*
>>> println(strLenSafe("abe"))
3
>>> println(strLenSafe(null))
0*/

interface User6_6 {
    val nickname: String
}


class UserImpl6_6_1(override val nickname: String) : User6_6

class UserImpl6_6_2 : User6_6 {
    override val nickname: String
        get() = TODO("Not yet implemented")
}

class UserImpl6_6_3(val accountId: Int) : User6_6 {
    override val nickname = getFacebookName(accountId)
}


object Version {
    const val KOTEST = "1.1.1"
}

interface Clickable {
    fun click()
}

class Button : Clickable {
    override fun click() {
        TODO("Not yet implemented")
    }

}

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}

fun main() {
    println("Kotlin".lastChar)

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)
    //super<InterfaceType>.showOff()

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
//    lengthCounter.counter = 1
    println(lengthCounter.counter)
//    val animated = Animated()
}

abstract class Animated {  // 이 클래스는 추상클래스다. 이 클래스의 인스턴스를 만들 수 없다
    abstract fun animate()  // 이 함수는 추상 함수다. 이 함수에는 구현이 없다. 하위 클래스에서는 이 함수를 반드시 오버라이드해야 한다.

    // 추상 클래스에 속했더라도 비 추상 함수는 기본적으로 파이널 이지만 원한다면 open 으로 오버라이드를 허용할 수 있다.
    open fun stopAnimating() {
    }

    fun animateTwice() {
    }
}

open class View(val ctx: Context)

class MyButton : View {  // 클래스 헤더에 있는 클래스 이름뒤에 괄호가 없다.
    constructor(ctx: Context) : super(ctx) // 상위 클래스의 생성자를 호출한다.

//    override val ctx: Context
//        get() = TODO("Not yet implemented")
}

fun String.joinToString() {

}

class ThisClass() {
    lateinit var nickname: String

    constructor(nickname: String) : this() {
        this.nickname = nickname
    }
}
/*

class MyButton_2 : View {
    constructor(ctx: Context): this(ctx, MY_STYLE){
        //..
    }

    constructor(ctx: Context, attr:AttributeSet): super(ctx, attr){
        //...
    }
}
*/
