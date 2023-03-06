package patterns.structural.adapter

interface Duck {
    fun quack()
    fun fly()
}

class MallardDuck : Duck {
    override fun quack() {
        println("Quack")
    }

    override fun fly() {
        println("I'm flying")
    }

}

interface Turkey {
    fun gobble()
    fun fly()
}

class WildTurkey : Turkey {
    override fun gobble() {
        println("Gobble")
    }

    override fun fly() {
        println("I'm flying a short distance")
    }

}

class TurkeyAdapter(
    private val turkey: Turkey
) : Duck {

    override fun quack() {
        turkey.gobble()
    }

    override fun fly() {
        for (i in 0..5) {
            turkey.fly()
        }
    }

}
