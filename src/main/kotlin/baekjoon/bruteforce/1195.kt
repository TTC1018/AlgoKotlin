package baekjoon.baekjoon.bruteforce

class `1195` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val A = readLine()
        val B = readLine()

        val (shorter, longer) = listOf(A, B).sortedBy { it.length }
        var p = -(shorter.length - 1)
        var answer = shorter.length + longer.length
        loop@ while (p < longer.length) {
            var cnt = 0
            for (i in shorter.indices) {
                if (p + i in longer.indices) {
                    when {
                        shorter[i] == '1' || longer[p + i] == '1' -> cnt++
                        else -> {
                            p++
                            continue@loop
                        }
                    }
                }
            }

            p++
            answer = minOf(answer, shorter.length + longer.length - cnt)
        }

        print(answer)
    }
}

fun main() {
    `1195`().solution()
}