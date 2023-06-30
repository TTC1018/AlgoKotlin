package baekjoon.string


class `14369` {

    private lateinit var S: String
    private lateinit var counter: MutableMap<Char, Int>
    private val m = buildMap<Int, Map<Char, Int>> {
        put(0, buildMap { "ZERO".forEach { s -> put(s, this.getOrDefault(s, 0) + 1) } })
        put(1, buildMap { "ONE".forEach { s -> put(s, this.getOrDefault(s, 0) + 1) } })
        put(2, buildMap { "TWO".forEach { s -> put(s, this.getOrDefault(s, 0) + 1) } })
        put(3, buildMap { "THREE".forEach { s -> put(s, this.getOrDefault(s, 0) + 1) } })
        put(4, buildMap { "FOUR".forEach { s -> put(s, this.getOrDefault(s, 0) + 1) } })
        put(5, buildMap { "FIVE".forEach { s -> put(s, this.getOrDefault(s, 0) + 1) } })
        put(6, buildMap { "SIX".forEach { s -> put(s, this.getOrDefault(s, 0) + 1) } })
        put(7, buildMap { "SEVEN".forEach { s -> put(s, this.getOrDefault(s, 0) + 1) } })
        put(8, buildMap { "EIGHT".forEach { s -> put(s, this.getOrDefault(s, 0) + 1) } })
        put(9, buildMap { "NINE".forEach { s -> put(s, this.getOrDefault(s, 0) + 1) } })
    }

    private var t = 1
    private lateinit var answer: MutableSet<String>
    private val sb = StringBuilder()
    private fun dfs(num: Int) {
        if (num == 10)
            return

        if (counter.values.all { it == 0 }) {
            answer.add("Case #${t + 1}: $sb")
            return
        }

        for (n in num..9) {
            if (m[n]!!.all { (k, v) -> counter.getOrDefault(k, 0) >= v }) {
                m[n]!!.forEach { (k, v) -> counter[k] = counter.getOrDefault(k, 0) - v }
                sb.append(n)
                dfs(n)
                sb.deleteAt(sb.length - 1)
                m[n]!!.forEach { (k, v) -> counter[k] = counter.getOrDefault(k, 0) + v }
            } else
                dfs(n + 1)
        }
    }


    fun solution() = with(System.`in`.bufferedReader()) {
        repeat(readLine().toInt()) {
            answer = mutableSetOf()
            t = it
            S = readLine()
            counter = S.groupBy { s -> s }
                .mapValues { (_, v) -> v.size }
                .toMutableMap()
            dfs(0)
            println(answer.first())
        }
    }
}

fun main() {
    `14369`().solution()
}