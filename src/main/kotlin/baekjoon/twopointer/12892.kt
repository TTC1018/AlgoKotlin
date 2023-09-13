package baekjoon.twopointer

class `12892` {
    private var N = 0
    private var D = 0
    private lateinit var G: List<Gift>

    private data class Gift(
        val p: Int,
        val v: Int
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run { N = first(); D = last() }
        G = List(N) { readLine().split(" ").map(String::toInt).run { Gift(first(), last()) } }
            .sortedBy { it.p }

        val P = LongArray(N + 1).apply {
            this[0] = 0
            for (i in 1 .. N) {
                this[i] += (this[i - 1] + G[i - 1].v.toLong())
            }
        }

        var answer = 0L
        var (p1, p2) = 1 to 1
        while (p1 <= N && p2 <= N) {
            when {
                p1 == p2 -> {
                    answer = maxOf(answer, P[p1] - P[p1 - 1])
                    p2++
                }
                G[p2 - 1].p - G[p1 - 1].p < D -> {
                    answer = maxOf(answer, P[p2] - P[p1 - 1])
                    p2++
                }
                else -> p1++
            }
        }
        print(answer)
    }
}

fun main() {
    `12892`().solution()
}