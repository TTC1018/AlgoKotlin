package baekjoon.math

class `3474` {
    fun solution() = with(System.`in`.bufferedReader()) {
        // 0의 개수 -> 10곱해질때마다 생김
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            val N = readLine().toInt()
            var m = 5
            var answer = 0L
            while (m <= N) {
                answer += N.div(m)
                m *= 5
            }
            sb.appendLine(answer)
        }
        print(sb.dropLast(1))
    }
}