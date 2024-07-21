package oop

/**
 * 깊고 복잡한 상속관계는 코드의 가독성을 떨어뜨릴 수 있음.
 * 상속의 복잡성 문제는 합성(composition), 인터페이스, 위임(delegation)이라는 세가지 기술적 방법을 통해 해결
 */
interface Flyable {
    fun fly()
}

interface Tweetable {
    fun tweet()
}

interface EggLayable {
    fun layEgg()
}

class Ostrich: Tweetable, EggLayable {
    override fun tweet() { TODO("Not yet implemented") }
    override fun layEgg() { TODO("Not yet implemented") }
}

class Sparrow: Flyable, Tweetable, EggLayable {
    override fun fly() { TODO("Not yet implemented") }
    override fun tweet() { TODO("Not yet implemented") }
    override fun layEgg() { TODO("Not yet implemented") }
}

/**
 * 알을 낳는 모든 새는 layEgg() 메서드를 구현해야 하는데, 대부분 구현 논리는 동일하기 때문에,
 * 코드중복 문제가 발생함.
 *
 * 합성이나 위임을 통해 중복을 제거할 수 있다.
 */
class FlyAbility : Flyable {
    override fun fly() { TODO("Not yet implemented") }
}

class TweetAbility : Tweetable {
    override fun tweet() { TODO("Not yet implemented") }
}

class EggLayAbility : EggLayable {
    override fun layEgg() { TODO("Not yet implemented") }
}

class Ostrich2(
    private val tweetAbility: TweetAbility = TweetAbility(), // 합성
    private val eggLayAbility: EggLayAbility = EggLayAbility() // 합성
) : Tweetable, EggLayable {
    override fun tweet() {
        tweetAbility.tweet() // 위임
    }

    override fun layEgg() {
        eggLayAbility.layEgg() // 위임
    }
}
