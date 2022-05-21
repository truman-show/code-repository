package org.example.anki

// I'm a view!
// javaClass

open class User_5_16(val name: String) {
    fun click() {
        println("I'am User_5_16")
    }

}

class TwitterUser_5_16(name: String) : User_5_16(name) {
    fun overClick() {
        super.click()
    }
}


fun test_5_16(
    nickname: String,
    name: String
) {

}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}


class Member_5_16 {
    var name: String = ""
}

//val String.lastChar: Char
//    get() = get(length - 1)


val String.lastChar: Char
    get() {
        return get(length - 1)
    }

class User_516_1 constructor(_nickname: String) {    // 파라미터가 하나만 있는 주 생성자
    val nickname: String

    init {    // 초기화 블록
        nickname = _nickname
    }
}

class User_516_2(_nickname: String) {    // 파라미터가 하나만 있는 주 생성자
    val nickname: String

    init {    // 초기화 블록
        nickname = _nickname
    }
}

class User_516_3(_nickname: String) {    // 파라미터가 하나만 있는 주 생성자
    val nickname = _nickname

}

class User_516_4(val nickname: String) {    // 파라미터가 하나만 있는 주 생성자
}

class User_516_5 {
    var name: String = ""
}

fun <T> Collection<T>.joinToString() {

}


// super<Cliacleable>.showOff()

/*

fun main(arrgs: Arrays) {
    println("Hello, world")
}
*/

class User_516(val id: Int, val name: String, val address: String)

//확장함수
fun User_516.validateBeforeSave() {
    fun validate(field: String, fieldName: String) {
        if (field.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${this.id} : empty $fieldName")
        }
    }
    validate(name, "name")
    validate(address, "address")
}

fun saveUser(user: User_516) {
    /*
    if (user.name.isEmpty()){
        throw IllegalArgumentException("Can't save user ${user.id} : empty Name")
    }
    if (user.address.isEmpty()){
        throw IllegalArgumentException("Can't save user ${user.id} : empty Address")
    }
    */
/*
    확장함수 사용하지 않음
    fun validate(field: String, fieldName: String) {
        if (field.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id} : empty $fieldName")
        }
    }
*/
    user.validateBeforeSave()

}


fun main() {
    test_5_16(nickname = "ljihoon", "")
    setOf(1, 2, 3)

    saveUser(User_516(1, "이지훈", ""))
}

class LengthCounter {
    var counter: Int = 0
        private set // 아래 코드와 동일하다
    /*
    private set(value) {
        field = value
    }
    */

    fun addWord(word: String) {
        counter += word.length
    }
}


class Client(val name: String, val postalCode: Int) {
    override fun toString() = "Client(name=$name, postalCode=$postalCode)"

    override fun hashCode(): Int = name.hashCode() * 31 + postalCode
}
