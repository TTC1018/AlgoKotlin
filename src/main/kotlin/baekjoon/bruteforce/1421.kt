package baekjoon.bruteforce

class `1421` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, C, W) = readLine().split(" ").map(String::toInt)
        val T = List(N) { readLine().toInt() }

        var answer = 0L
        for (i in 1..T.maxOf { it }) {
            var tempAnswer = 0L
            for (t in T) {
                val cost = t.div(i).run { if (t % i == 0) this*(W*i-C)+C else this*(W*i-C) }
                if (cost > 0)
                    tempAnswer += cost
            }
            answer = maxOf(answer, tempAnswer)
        }
        print(answer)
    }
}