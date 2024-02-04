package baekjoon.greedy

class `3088` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val F = List(N) { readLine().split(" ").map(String::toInt) }

        val crashed = mutableSetOf<Int>()
        var answer = 0
        for (i in 0 until N) {
            if (F[i].all { it !in crashed }) {
                answer++
            }
            crashed.addAll(F[i])
        }
        print(answer)
    }
}