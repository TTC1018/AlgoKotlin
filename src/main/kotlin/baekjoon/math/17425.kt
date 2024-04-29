package baekjoon.math

class `17425` {
    fun solution() = with(System.`in`.bufferedReader()) {
        // 약수 대신 배수를 기록
        val sumVal = LongArray(1000000 + 1) { it.toLong() }.apply {
            val half = kotlin.math.sqrt(1000000.0).toInt()
            for (n in 2..half) {
                for (i in 2..1000000.div(n)) {
                    this[n * i] += n.toLong()
                    if (i > 1000)
                        this[n * i] += i.toLong()
                }
            }
            for (n in 2..1000000) {
                this[n]++
            }
            for (n in 2..1000000) {
                this[n] += this[n - 1]
            }
        }

        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            val N = readLine().toInt()
            sb.appendLine(sumVal[N])
        }
        print(sb.dropLast(1))
    }
}