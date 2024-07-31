package patterns.creational.abstractfactory

/**
 * Abstract factory knows about all (abstract) product types.
 */
interface GUIFactory {
    fun createButton(): Button
    fun createCheckbox(): Checkbox
}

class MacOSFactory : GUIFactory {
    override fun createButton(): Button = MacOSButton()
    override fun createCheckbox(): Checkbox = MacOSCheckbox()
}


class WindowFactory : GUIFactory {
    override fun createButton(): Button = WindowButton()
    override fun createCheckbox(): Checkbox = WindowCheckbox()
}
