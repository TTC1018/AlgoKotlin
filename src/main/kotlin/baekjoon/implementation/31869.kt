package baekjoon.implementation

class `31869` {
    private data class Memo(
        val S: String,
        val P: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val dates = List(10) { List(7) { mutableListOf<Memo>() } }.apply {
            repeat(N) {
                val (S, W, D, P) = readLine().split(" ")
                this[W.toInt() - 1][D.toInt()].add(Memo(S, P.toInt()))
            }
        }
        val W = buildMap<String, Int> {
            repeat(N) {
                readLine().split(" ").run {
                    put(first(), last().toInt())
                }
            }
        }

        var answer = 0
        var prev = 0
        for (week in dates) {
            var cnt = prev
            for (d in week.indices) {
                if (week[d].isEmpty()) {
                    cnt = 0
                } else {
                    if (week[d].any { (S, P) -> W[S]!! >= P }) {
                        cnt++
                        answer = maxOf(answer, cnt)
                    } else {
                        cnt = 0
                    }
                }
            }
            prev = cnt
        }
        print(answer)
    }
}