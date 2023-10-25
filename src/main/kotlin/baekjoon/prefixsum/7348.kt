package baekjoon.prefixsum

class `7348` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val answer = mutableListOf<Int>()
        repeat(readLine().toInt()) {
            val N = readLine().toInt()
            val P = IntArray(200)

            repeat(N) {
                val (a, b) = readLine().split(" ").map { it.toInt() - 1 }.sorted()
                for (i in a.div(2)..b.div(2))
                    P[i]++
            }

            answer.add(P.maxOf { it } * 10)
        }
        print(answer.joinToString("\n"))
    }
}