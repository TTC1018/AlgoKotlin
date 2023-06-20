package baekjoon.bruteforce

class `17610` {

    private var k = 0
    private lateinit var G: IntArray
    private lateinit var able: BooleanArray

    private fun bruteforce(idx: Int, total: Int) {
        if (total > 0)
            able[total] = true

        for (i in idx until k) {
            bruteforce(i+1, total + G[i])
            bruteforce(i+1, total - G[i])
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        k = readLine().toInt()
        G = readLine().split(" ").map(String::toInt).toIntArray()
        able = BooleanArray(G.sumOf { it } + 1) { false }
            .also { it[0] = true }

        bruteforce(0, 0)

        print(able.count { it.not() })
    }

}

fun main() {

    `17610`().solution()

}