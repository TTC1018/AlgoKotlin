package baekjoon

class `6209` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (d, n, m) = readLine().split(" ").map(String::toInt)
        val island = (listOf(0, d) + List(n) { readLine().toInt() }).sorted()
        val diff = island.zipWithNext().map { (prev, next) -> next - prev }

        var answer = d
        var left = 0
        var right = d

        while (left <= right) {
            val mid = (left + right) / 2

            var cnt = 0
            diff.fold(0) { stacked, dist ->
                when {
                    stacked + dist < mid -> {
                        cnt++
                        stacked + dist
                    }
                    else -> 0
                }
            }

            when {
                cnt <= m -> {
                    left = mid + 1
                    answer = mid
                }
                else -> right = mid - 1
            }
        }
        print(answer)
    }
}

fun main() {
    `6209`().solution()
}