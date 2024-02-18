package baekjoon.sorting

class `4159` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        loop@ while (true) {
            val n = readLine().toInt()
            if (n == 0) {
                break
            }

            val S = List(n) { readLine().toInt() }.sorted()
            if (S.zipWithNext().all { (p, n) -> n - p <= 200 } && 1422 - S.last() <= 100) {
                sb.appendLine("POSSIBLE")
            } else {
                sb.appendLine("IMPOSSIBLE")
            }

        }
        print(sb.dropLast(1))
    }
}