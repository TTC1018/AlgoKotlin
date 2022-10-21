package baekjoon.greedy

class `11501` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val T = readLine().toInt()
        repeat(T) {
            var answer = 0L

            val N = readLine().toInt()
            val S = readLine().split(" ").map { it.toInt() }

            var maxValue = S.last()
            for (i in N - 2 downTo 0) {

                if (S[i] < maxValue)
                    answer += (maxValue - S[i])
                else
                    maxValue = S[i]

            }

            println(answer)
        }

    }

}

fun main() {

    `11501`().solution()

}