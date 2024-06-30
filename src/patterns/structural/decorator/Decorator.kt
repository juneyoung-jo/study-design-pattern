package patterns.structural.decorator

interface IA {
    fun f()
}

class A : IA {
    override fun f() {
        TODO("Not yet implemented")
    }
}

class ADecorator(
    private val a: IA
) : IA {
    override fun f() {
        // 기능 향상 코드
        a.f()
        // 기능 향상 코드
    }
}
