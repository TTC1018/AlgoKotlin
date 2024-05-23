package baekjoon.math

class `10434` {
    private val P = BooleanArray(10000 + 1) { true }.apply {
        fill(false, 0, 2)
        for (n in 2..100) {
            for (i in 2..10000.div(n)) {
                this[n * i] = false
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            val V = mutableSetOf<Int>()
            var (t, M) = readLine().split(" ").map(String::toInt)
            if (P[M].not()) {
                sb.appendLine("$t $M NO")
            } else {
                val firstM = M
                while (M != 1 && M !in V) {
                    V.add(M)
                    M = "$M".map(Char::digitToInt).sumOf { it * it }
                }

                sb.appendLine(
                    if (M == 1) {
                        "$t $firstM YES"
                    } else {
                        "$t $firstM NO"
                    }
                )
            }
        }
        print(sb.dropLast(1))
    }
}