package baekjoon.greedy

class `12934` {
    fun solution() = with(System.`in`.bufferedReader()) {
        var (x, y) = readLine().split(" ").map(String::toLong)
        var maxN = 1L
        while (maxN * (maxN + 1) <= 2 * (x + y)) {
            if (maxN * (maxN + 1) == 2 * (x + y)) {
                val first = maxN
                while (x > 0) {
                    x -= maxN--
                }
                print(first - maxN)
                return
            }
            maxN++
        }
        print(-1)
    }
}