package baekjoon.casework

class `23252` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            var (A, B, C) = readLine().split(" ").map(String::toInt)
            if (A > 0 && B % 2 == 1) {
                B--
            }
            (A - C).takeIf { it >= 0 && it % 2 == 0 && B % 2 == 0 }
                ?.run { sb.appendLine("Yes") }
                ?: run { sb.appendLine("No") }
        }
        print(sb.dropLast(1))
    }
}