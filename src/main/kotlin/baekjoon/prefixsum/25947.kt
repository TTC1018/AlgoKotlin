package baekjoon.prefixsum

class `25947` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (n, b, a) = readLine().split(" ").map(String::toInt)
        val G = readLine().split(" ").map(String::toLong).sorted()
        val P = LongArray(n).apply {
            this[0] = G.first()
            for (i in 1 until n) {
                this[i] += (this[i - 1] + G[i])
            }
        }

        for (i in G.indices) {
            val sumVal = if (i > a) { // 상위 a개만 반값 할인
                (P[i] - P[i - a]).div(2) + P[i - a]
            } else {
                P[i].div(2)
            }

            if (sumVal > b) {
                print(i)
                return
            }
        }
        print(n)
    }
}