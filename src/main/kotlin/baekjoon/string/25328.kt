package baekjoon.string

class `25328` {
    private var k = 0
    private val counter = mutableMapOf<String, Int>()
    private lateinit var V: BooleanArray
    private val sb = StringBuilder()

    private fun bruteforce(s: String, idx: Int) {
        if (sb.length == k) {
            counter["$sb"] = counter.getOrDefault("$sb", 0) + 1
            return
        }

        for (i in idx until s.length) {
            if (V[i].not()) {
                V[i] = true
                sb.append(s[i])
                bruteforce(s, i + 1)
                sb.deleteAt(sb.length - 1)
                V[i] = false
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val XYZ = List(3) { readLine() }
        k = readLine().toInt()
        for (s in XYZ) {
            V = BooleanArray(s.length) { false }
            sb.clear()
            bruteforce(s, 0)
        }
        val answer = counter.filterValues { it >= 2 }.toSortedMap()
        if (answer.isEmpty())
            print(-1)
        else
            print(answer.keys.joinToString("\n"))
    }
}