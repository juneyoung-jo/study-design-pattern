package patterns.creational

/**
 * Base factory class. Note that "factory" is merely a role for the class. It
 * should have some core business logic which needs different products to be
 * created.
 */
abstract class Dialog {
    fun renderWindow() {
        val okButton = createButton()
        okButton.render()
    }

    /**
     * Subclasses will override this method in order to create specific button
     * objects.
     */
    abstract fun createButton(): Button
}

/**
 * HTML Dialog will produce HTML buttons.
 */
class HtmlDialog : Dialog() {
    override fun createButton(): Button =
        HtmlButton()
}

/**
 * Windows Dialog will produce Windows buttons.
 */
class WindowsDialog : Dialog() {
    override fun createButton(): Button =
        MacButton()
}

interface Button {
    fun render()
    fun onClick()
}

class HtmlButton : Button {
    override fun render() {
        println("Html Button")
        onClick()
    }

    override fun onClick() {
        println("Click! Button says - Html Button")
    }
}

class MacButton : Button {
    override fun render() {
        println("Mac Button")
        onClick()
    }

    override fun onClick() {
        println("Click! Button says - Mac Button")
    }
}

fun main() {
    configuration().run {
        this.renderWindow()
    }
}

private fun configuration(): Dialog {
    if (System.getProperty("os.name").equals("Mac OS X")) {
        return WindowsDialog()
    }
    return HtmlDialog()
}
