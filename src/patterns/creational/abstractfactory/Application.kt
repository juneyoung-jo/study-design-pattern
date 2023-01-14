package patterns.creational.abstractfactory

import java.util.*

fun main() {
    val application = configureApplication()
    application.paint()
}

fun configureApplication(): Application {
    val osName = System.getProperty("os.name").lowercase(Locale.getDefault())
    return if (osName.contains("mac")) {
        Application(MacOSFactory())
    } else {
        Application(WindowFactory())
    }
}

/**
 * Factory users don't care which concrete factory they use since they work with
 * factories and products through abstract interfaces.
 */
class Application(
    factory: GUIFactory
) {
    private val button: Button = factory.createButton()
    private val checkbox: Checkbox = factory.createCheckbox()

    fun paint() {
        button.paint()
        checkbox.paint()
    }

}
