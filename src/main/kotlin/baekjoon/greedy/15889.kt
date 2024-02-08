package baekjoon.greedy

class `15889` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val L = readLine().split(" ").map(String::toInt)
        if (N == 1) {
            print("권병장님, 중대장님이 찾으십니다")
        } else {
            val B = readLine().split(" ").map(String::toInt)
            val visited = BooleanArray(L.last() + 1) { false }.apply { this[0] = true }
            for (i in 0 until N - 1) {
                if (visited[L[i]]) {
                    for (next in L[i]..(L[i] + B[i]).coerceAtMost(L.last())) {
                        visited[next] = true
                    }
                }
            }

            if (visited.last()) {
                print("권병장님, 중대장님이 찾으십니다")
            } else {
                print("엄마 나 전역 늦어질 것 같아")
            }
        }
    }

}