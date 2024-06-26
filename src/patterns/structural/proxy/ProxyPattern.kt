package patterns.structural.proxy

interface Database {
    fun query(sql: String): String
}

class RealDatabase : Database {
    override fun query(sql: String): String {
        println("Querying $sql")
        return "Result from database"
    }
}

class DatabaseProxy(
    private val realDatabase: RealDatabase
) : Database {
    private val cache = mutableMapOf<String, String>()

    override fun query(sql: String): String {
        if (cache.containsKey(sql)) {
            println("Returning cached result: $sql")
            return cache[sql]!!
        }
        val result = realDatabase.query(sql)
        cache[sql] = result
        return result
    }
}

fun main() {
    val realDatabase = RealDatabase()
    val databaseProxy = DatabaseProxy(realDatabase)

    // 첫 번쨰 쿼리: 실제 DB 수행
    println(databaseProxy.query("SELECT * FROM users"))

    // 두 번쨰 쿼리: 캐시된 데이터
    println(databaseProxy.query("SELECT * FROM users"))
}
