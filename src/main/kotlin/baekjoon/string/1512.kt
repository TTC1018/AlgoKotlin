package baekjoon.string

class `1512` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val M = readLine().toInt()
        val S = readLine()
        var answer = Int.MAX_VALUE

        for (l in M downTo 1) {
            var tempAnswer = 0
            val counter = mutableMapOf<Char, Int>()

            for (start in 0 until l) {
                var total = 0
                for (j in start until S.length step l) {
                    counter[S[j]] = counter.getOrDefault(S[j], 0) + 1
                    total++
                }
                tempAnswer += (total - counter.maxOf { it.value })
                counter.clear()
            }

            answer = minOf(answer, tempAnswer)
        }
        print(answer)
    }
}

fun main() {
    `1512`().solution()
}