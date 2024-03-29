package baekjoon.implementation

class `4881` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        loop@ while (true) {
            var (A, B) = readLine().split(" ").map(String::toInt)
            val (fa, fb) = A to B
            if (A == 0 && B == 0)
                break

            val a = buildSet {
                while (A !in this) {
                    add(A)
                    A = "$A".map { it.digitToInt().run { this * this } }.sumOf { it }
                }
            }
            val b = buildSet {
                while (B !in this) {
                    add(B)
                    B = "$B".map { it.digitToInt().run { this * this } }.sumOf { it }
                }
            }

            a.map { b.indexOf(it) }
                .filter { it >= 0 }
                .takeIf { it.isNotEmpty() }
                ?.let {
                    val minVal = it.minOf { idx -> idx + a.indexOf(b.elementAt(idx)) } + 2
                    sb.appendLine("$fa $fb $minVal")
                } ?: sb.appendLine("$fa $fb 0")
        }
        print(sb.dropLast(1))
    }
}