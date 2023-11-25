package baekjoon.graph

class `28423` {
    private val memo = mutableMapOf<Int, Int>()

    private fun f(num: Int): Int {
        val s = num.toString().map(Char::digitToInt)
        val sum = s.sumOf { it }
        val multi = if (0 in s) 0 else s.reduce { acc, i -> acc * i }
        return "$sum$multi".toInt()
    }

    private fun g(now: Int): Int {
        if (now > 100000)
            return -1
        if (now in memo)
            return memo[now]!!

        val result = f(now)
        return if (now == result) {
            memo[now] = 1
            1
        } else {
            memo[now] = 0 // 방문 처리
            memo[now] = g(result)
            return memo[now]!!
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val (L, R) = readLine().split(" ").map(String::toInt)
        print((L..R).map { g(it) }.sumOf { it })
    }
}