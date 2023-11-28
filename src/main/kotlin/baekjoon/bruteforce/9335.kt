package baekjoon.bruteforce

class `9335` {
    private var n = 0
    private lateinit var f: List<List<Int>>
    private var answer = Int.MAX_VALUE
    private lateinit var visited: IntArray

    private fun bruteforce(now: Int, cnt: Int) {
        if (visited.all { it >= 1 }) {
            answer = minOf(answer, cnt)
        }
        if (now == n)
            return

        // 선택
        visited[now]++
        f[now].forEach { visited[it]++ }
        bruteforce(now + 1, cnt + 1)
        visited[now]--
        f[now].forEach { visited[it]-- }

        // 미선택
        bruteforce(now + 1, cnt)
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        print(
            buildList {
                repeat(readLine().toInt()) {
                    n = readLine().toInt()
                    f = buildList {
                        repeat(n) {
                            add(readLine().split(" ").map { it.toInt() - 1 }.drop(1))
                        }
                    }
                    visited = IntArray(n)
                    answer = n
                    bruteforce(0, 0)
                    add(answer)
                }
            }.joinToString("\n")
        )
    }
}