package baekjoon.prefixsum

class `25682` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M, K) = readLine().split(" ").map(String::toInt)
        val B = List(N) { readLine() }
        // 최대는? 기본 4000000만개 + K=50이면 1억개 넘어감
        val firstBlack = List(N) { IntArray(M) }
        val firstWhite = List(N) { IntArray(M) }
        repeat(N) { i ->
            repeat(M) { j ->
                if ((i + j) % 2 == 0) {
                    if (B[i][j] != 'B') {
                        firstBlack[i][j] = 1
                    } else {
                        firstWhite[i][j] = 1
                    }
                } else {
                    if (B[i][j] != 'W') {
                        firstBlack[i][j] = 1
                    } else {
                        firstWhite[i][j] = 1
                    }
                }
            }
        }

        for (i in 1 until N) {
            firstBlack[i][0] += firstBlack[i-1][0]
            firstWhite[i][0] += firstWhite[i-1][0]
        }
        for (j in 1 until M) {
            firstBlack[0][j] += firstBlack[0][j-1]
            firstWhite[0][j] += firstWhite[0][j-1]
        }
        for (i in 1 until N) {
            for (j in 1 until M) {
                firstBlack[i][j] += (firstBlack[i-1][j]+firstBlack[i][j-1]-firstBlack[i-1][j-1])
                firstWhite[i][j] += (firstWhite[i-1][j]+firstWhite[i][j-1]-firstWhite[i-1][j-1])
            }
        }

        var answer = Int.MAX_VALUE
        for (i in K-1 until N) {
            for (j in K-1 until M) {
                var bAnswer = firstBlack[i][j]
                var wAnswer = firstWhite[i][j]
                if (i-K >= 0) {
                    bAnswer -= firstBlack[i-K][j]
                    wAnswer -= firstWhite[i-K][j]
                }
                if (j-K >= 0) {
                    bAnswer -= firstBlack[i][j-K]
                    wAnswer -= firstWhite[i][j-K]
                }
                if (i-K >= 0 && j-K >= 0) {
                    bAnswer += firstBlack[i-K][j-K]
                    wAnswer += firstWhite[i-K][j-K]
                }

                answer = minOf(answer, bAnswer, wAnswer)
            }
        }
        print(answer)
    }
}