package patterns.behavioral

// Abstract Class 정의
abstract class DataProcessor {

    fun process() {
        readData()
        processData()
        writeData()
    }

    abstract fun writeData()
    abstract fun processData()
    abstract fun readData()
}

// Concrete Class 구현
class CsvDataProcessor : DataProcessor() {
    override fun writeData() {
        println("Reading data from CSV file")
    }

    override fun processData() {
        println("Processing CSV data")
    }

    override fun readData() {
        println("Writing data to CSV file")
    }
}

class JsonDataProcessor : DataProcessor() {
    override fun writeData() {
        println("Writing data to JSON file")
    }

    override fun processData() {
        println("Processing JSON data")
    }

    override fun readData() {
        println("Reading data from JSON file")
    }
}

fun main() {
    val csvDataProcessor: DataProcessor = CsvDataProcessor()
    csvDataProcessor.processData()

    println("================================================")

    val jsonProcessor: DataProcessor = JsonDataProcessor()
    jsonProcessor.processData()
}
