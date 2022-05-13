package ch04.Button1

import java.io.Serializable

interface State : Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class Button : View {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) { /*...*/
    }

    // 이 클래스는 자바의 정적 중첩 클래스와 대응한다 (class 내부 static class)
    class ButtonState : State { /*...*/ }
    /*
    static class ButtonState implements State {
        /*...*/
    }
     */
}
