package baekjoon.binarysearch

class `17179` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M, L) = readLine().split(" ").map(String::toInt)
        val S = List(M) { readLine().toInt() }
        val Q = List(N) { readLine().toInt() }

        for (q in Q) {
            var (l, r) = 1 to L - 1
            var answer = 0
            while (l <= r) {
                val m = (l + r).div(2)
                var cnt = 0
                var fixed = 0

                for (s in S) {
                    if (s - fixed >= m) {
                        fixed = s
                        cnt++
                    }
                }

                if (cnt < q || (cnt == q && L - fixed < m)) {
                    r = m - 1
                } else {
                    l = m + 1
                    answer = m
                }
            }
            println(answer)
        }
    }
}

fun main() {
    `17179`().solution()
}