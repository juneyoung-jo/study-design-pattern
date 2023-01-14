package patterns.creational.abstractfactory

/**
 * Abstract Factory assumes that you have several families of products,
 * structured into separate class hierarchies (Button/Checkbox). All products of
 * the same family have the common interface.
 *
 * This is the common interface for buttons family.
 */
interface Button {
    fun paint()
}

class MacOSButton : Button {
    override fun paint() {
        println("You have created MacOSButton.")
    }
}

class WindowButton : Button {
    override fun paint() {
        println("You have created WindowButton.")
    }

}
