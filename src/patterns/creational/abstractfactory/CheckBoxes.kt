package patterns.creational.abstractfactory

/**
 * Checkboxes is the second product family. It has the same variants as buttons.
 */
interface Checkbox {
    fun paint()
}

class MacOSCheckbox : Checkbox {
    override fun paint() {
        println("You have created MacOSCheckbox.")
    }
}

class WindowCheckbox : Checkbox {
    override fun paint() {
        println("You have created WindowCheckbox.")
    }
}
