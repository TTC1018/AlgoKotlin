package baekjoon.math

class `25562` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val sb = StringBuilder()
        sb.appendLine(N * (N - 1) / 2)
        sb.appendLine(
            buildList<Int> {
                add(1)
                repeat(N - 1) {
                    add(last() * 2)
                }
            }.joinToString(" ")
        )
        sb.appendLine(N - 1)
        sb.append((1 .. N).joinToString(" "))
        print(sb)
    }
}