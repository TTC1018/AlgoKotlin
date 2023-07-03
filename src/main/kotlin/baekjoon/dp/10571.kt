package baekjoon.dp

class `10571` {
    private data class Diamond(
        val w: Double,
        val c: Double
    )
    
    fun solution() = with(System.`in`.bufferedReader()) {
        repeat(readLine().toInt()) {
            val n = readLine().toInt()
            val D = Array(n) { readLine().split(" ").map(String::toDouble).let { Diamond(it[0], it[1]) } }
            val dp = IntArray(n) { 1 }

            for (i in 1 until n) {
                for (j in 0 until i) {
                    if (D[i].w > D[j].w && D[i].c < D[j].c)
                        dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }

            println(dp.maxOf { it })
        }
    }
}

fun main() {
    `10571`().solution()
}