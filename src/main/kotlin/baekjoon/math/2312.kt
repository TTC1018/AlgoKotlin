package baekjoon.math

class `2312` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            var N = readLine().toInt()
            val counter = mutableMapOf<Int, Int>()
            for (n in 2..N) {
                while (N % n == 0) {
                    counter[n] = counter.getOrDefault(n, 0) + 1
                    N /= n
                }
            }
            sb.appendLine(
                counter.toSortedMap()
                    .map { (k, v) -> "$k $v" }
                    .joinToString("\n")
            )
        }
        print(sb.dropLast(1))
    }
}