package ch03.ex3_4_2_NoOverridingForExtensionFunctions1

open class View {
    open fun click() = println("View clicked")
}

class Button: View() {
    override fun click() = println("Button clicked")
}

// View 확장 함수
fun View.showOff() = println("I'm a view!")

// Button 확장 함수
fun Button.showOff() = println("I'm a button!")

fun main() {
    val view: View = Button()   //Button 구현체를 가진 View 타입 view 객체
    view.showOff()  // View 타입 객체의 확장함수를 호출하게되면 ?
}
