package patterns.structural.bridge

/**
 *        Abstraction                 Implementor
 *         +--------+                  +--------+
 *         |        |                  |        |
 *         |        |                  |        |
 *         |        |  <-------------- |        |
 *         +--------+                  +--------+
 *             |                           |
 *             |                           |
 *      +------------+            +----------------+
 *      |            |            |                |
 *      |RefinedAbstraction|      |ConcreteImplementor|
 *      +------------+            +----------------+
 *
 */

// Abstraction
abstract class RemoteControl(protected val device: Device) {
    abstract fun turnOn()
    abstract fun turnOff()
}

// RefinedAbstraction
class AdvancedRemoteControl(device: Device) : RemoteControl(device) {
    fun mute() {
        device.setVolume(0)
        println("Device muted.")
    }

    override fun turnOn() {
        device.turnOn()
    }

    override fun turnOff() {
        device.turnOff()
    }
}

// Implementor
interface Device {
    fun turnOn()
    fun turnOff()
    fun setVolume(volume: Int)
}

//ConcreteImplementor
class TV : Device {
    private var volume: Int = 50

    override fun turnOn() {
        println("TV turned on.")
    }

    override fun turnOff() {
        println("TV turned off.")
    }

    override fun setVolume(volume: Int) {
        this.volume = volume
        println("TV setVolume set to $volume.")
    }
}
