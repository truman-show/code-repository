package org.example.anki.may

import ch04.ex4_2_2_CompanionObjects1.getFacebookName
import org.example.anki.Color
import org.example.anki.View
import org.junit.runner.manipulation.Ordering

class MyButton521 : View {  // 클래스 헤더에 있는 클래스 이름뒤에 괄호가 없다.
    constructor(ctx: Ordering.Context) : super(ctx) {  // 상위 클래스의 생성자를 호출한다.
    }
}

// public 어디서든 접근 가능
// 같은 모듈에서만 접근 가능
// 하위 접근 가능
// 내부에서 만 접근 가능

class User521 {
    var name: String = ""
    /*    set(value) {
            field = value
        }
        get() {
            return field
        }
    */
}
// 중위 호출

fun test(c: Int) {
    when (c) {
        in 1..10 -> println("1부터 10")
        !in 1..10 -> println("1 부터 10 외의 수")
    }
}

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.BLUE -> "Battle"
    }

// person.isMarried = false

interface View521_2 {
    val nickname: String
}

class Button521 : View521_2 {
    override val nickname: String
        get() = TODO("Not yet implemented")
}


fun <T> Collection<T>.joinToString(
    separator: String,
    prefix: String,
    posixfix: String
) {

}

class Person521(name: String, age: Int) {
    /*
    val name = name
        get() {
            return field
        }

    var age = age
        get() {
            return field
        }
        set(value) {
            field = value
        }
*/

    companion object
}


//내부 클래스
class Outer {
    inner class Innter {
        fun test() {
            this@Outer
        }
    }
}


class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}


class Client(val name: String, val postalCode: Int) {
    override fun toString() = "Client(name=$name, postalCode=$postalCode)"
}


fun main(args: Array<String>) {
    val client1 = Client("Alice", 342562)
    println(client1)

    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 1, 2))
    println("${cset.objectsAdded} objects were added, ${cset.size} remain")

    //val user5212 = User521_2(1, "ljihoon", "")
    //saveUser(user5212)

    val mapOf = mapOf(1 to "one", 2 to "two")
    println(mapOf)

}


class User521_2(val id: Int, val name: String, val address: String)

fun saveUser(user: User521_2) {

    fun validate521(field: String, fieldName: String) {
        if (field.isEmpty()) {
            throw IllegalArgumentException("$field is empty fieldName: $fieldName")
        }
    }

    validate521(user.name, "name")
    validate521(user.address, "address")
}

class User521_3 private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String): User521_3 = User521_3(email.substringBefore('@'))


        fun of(facebookAccountId: Int): User521_3 {
            return User521_3(getFacebookName(facebookAccountId))
        }
    }
/*
    constructor(email: String) {
        nickname = email.substringBefore('@')
    }

    constructor(facebookAccountId: Int) {
        nickname = getFacebookName(facebookAccountId)
    }*/
}

class User constructor(val nickname: String) {    // 파라미터가 하나만 있는 주 생성자

}


val String.lastChar: Char
    get() = get(length - 1)

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

class Outer521_2 {
    inner class Inner {

        fun getOuterReference(): Outer521_2 = this@Outer521_2
    }
}


fun test2() {
    for (i in 1 until 10) {

    }
}


//vararg
// 위임을 사용한 클래스
class CountingSet<T>(
    val innerSet: MutableCollection<T> = HashSet()
) : MutableCollection<T> by innerSet {

    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }
}

// 위임을 사용하지 않으면 override 해야한다
class CountingSet2<T> : MutableCollection<T> {
    override val size: Int
        get() = TODO("Not yet implemented")

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun addAll(elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun add(element: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): MutableIterator<T> {
        TODO("Not yet implemented")
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun remove(element: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun contains(element: T): Boolean {
        TODO("Not yet implemented")
    }

}





























