package baekjoon.string

class `1897` {
    private var n = 0
    private lateinit var s: String
    private lateinit var m: Map<Int, MutableList<String>>
    private val answer = mutableSetOf<String>()

    private fun dfs(now: String) {
        answer.add(now)

        val l = now.length + 1
        if (l !in m)
            return

        for (nextS in m[l]!!) {
            var idx = 0
            var nsIdx = 0
            while (nsIdx < nextS.length && idx < now.length) {
                if (nextS[nsIdx] == now[idx])
                    idx++
                nsIdx++
            }

            if (idx == now.length)
                dfs(nextS)
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").also { n = it[0].toInt(); s = it[1] }
        m = buildMap {
            repeat(n) {
                val key = readLine()
                if (key.length !in this) {
                    this[key.length] = mutableListOf<String>()
                }
                this[key.length]!!.add(key)
            }
        }

        dfs(s)
        print(answer.maxBy { it.length })
    }
}

fun main() { `1897`().solution() }