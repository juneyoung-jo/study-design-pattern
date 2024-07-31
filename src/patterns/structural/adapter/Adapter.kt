package patterns.structural.adapter

fun main() {
    val adaptee = Adaptee()
    val target = Adapter(adaptee)
    target.request()
}

class Adapter(
    private val adaptee: Adaptee
) : Target {

    override fun request() {
        adaptee.specificRequest()
    }

}

// 클라이언트가 사용하려는 인터페이스
interface Target {
    fun request()
}

// 이미 개발되어 수정이 어려운 기능
class Adaptee {
    fun specificRequest() {
        println("Specific request.")
    }
}
