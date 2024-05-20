package baekjoon.implementation

class `2811` {
    private data class Date(
        val date: Int,
        val idx: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val D = readLine().split(" ").map(String::toInt)
        val dates = buildList {
            var date = 0
            for (i in D.indices.reversed()) {
                if (D[i] < 0) {
                    date++
                } else if (date > 0) {
                    add(Date(date, i + 1))
                    date = 0
                }
            }
        }.sortedByDescending { it.date }
        val P = IntArray(N).apply {
            for ((date, idx) in dates) {
                this[idx]--
                this[(idx - date * 2).coerceAtLeast(0)]++
            }
            for (i in 1 until size) {
                this[i] += this[i - 1]
            }
        }

        val maxVal = dates.firstOrNull()?.date
        var temp = 0
        for ((date, i) in dates) {
            if (date != maxVal)
                break

            val s = (i - date * 3).coerceAtLeast(0)
            val e = (i - date * 2).coerceAtLeast(0)
            temp = temp.coerceAtLeast((s until e).count { P[it] == 0 })
        }
        print(P.count { it > 0 } + temp)
    }
}