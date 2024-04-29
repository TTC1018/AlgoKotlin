package baekjoon.greedy

class `22981` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toLong)
        val v = readLine().split(" ").map(String::toLong).sorted()
        var answer = Long.MAX_VALUE
        for (i in 0 until N.toInt() - 1) {
            val perMinute = v.first() * (i + 1) + v[i + 1] * (N - 1 - i)
            answer = minOf(answer, K.run { if (K % perMinute == 0L) K / perMinute else K / perMinute + 1 })
        }
        print(answer)
    }
}