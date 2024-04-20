package baekjoon.prefixsum

class `25682_2` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M, K) = readLine().split(" ").map(String::toInt)
        val G = List(N) { readLine() }
        val B = List(N) { IntArray(M) } // 첫번째 검은색일때
        val W = List(N) { IntArray(M) } // 첫번째 하얀색일때
        for (i in 0 until N) {
            for (j in 0 until M) {
                val n = i + j
                if (G[i][j] == 'B') {
                    if (n and 1 == 0) {
                        W[i][j]++
                    } else {
                        B[i][j]++
                    }
                } else {
                    if (n and 1 == 0) {
                        B[i][j]++
                    } else {
                        W[i][j]++
                    }
                }
            }
        }

        for (j in 1 until M) {
            B[0][j] += B[0][j - 1]
            W[0][j] += W[0][j - 1]
        }
        for (i in 1 until N) {
            B[i][0] += B[i - 1][0]
            W[i][0] += W[i - 1][0]
        }
        for (i in 1 until N) {
            for (j in 1 until M) {
                B[i][j] += (B[i - 1][j] + B[i][j - 1] - B[i - 1][j - 1])
                W[i][j] += (W[i - 1][j] + W[i][j - 1] - W[i - 1][j - 1])
            }
        }

        var answer = Int.MAX_VALUE
        for (i in K - 1 until N) {
            for (j in K - 1 until M) {
                answer = minOf(
                    answer,
                    W[i][j] - (W.getOrNull(i - K)?.getOrNull(j) ?: 0)
                            - (W.getOrNull(i)?.getOrNull(j - K) ?: 0) + (W.getOrNull(i - K)?.getOrNull(j - K) ?: 0),
                    B[i][j] - (B.getOrNull(i - K)?.getOrNull(j) ?: 0)
                            - (B.getOrNull(i)?.getOrNull(j - K) ?: 0) + (B.getOrNull(i - K)?.getOrNull(j - K) ?: 0)
                )
            }
        }
        print(answer)
    }
}