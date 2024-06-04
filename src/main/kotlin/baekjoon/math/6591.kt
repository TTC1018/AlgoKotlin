package baekjoon.math

class `6591` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        while (true) {
            val (n, k) = readLine().split(" ").map(String::toInt)
            if (n == 0 && k == 0)
                break

            var answer = 1L
            repeat(minOf(n - k, k)) {
                answer = answer * (n - it) / (it + 1)
            }
            sb.appendLine(answer)
        }
        print(sb.dropLast(1))
    }
}