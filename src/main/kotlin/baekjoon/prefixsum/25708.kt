package baekjoon.prefixsum

class `25708` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val d = List(N) { readLine().split(" ").map(String::toInt) }
        val rowP = List(N) { IntArray(M) }
        val colP = List(N) { IntArray(M) }
        for (i in 0 until N) {
            rowP[i][0] = d[i][0]
            for (j in 1 until M) {
                rowP[i][j] += (rowP[i][j - 1] + d[i][j])
            }
        }
        for (j in 0 until M) {
            colP[0][j] = d[0][j]
            for (i in 1 until N) {
                colP[i][j] += (colP[i - 1][j] + d[i][j])
            }
        }

        var answer = Int.MIN_VALUE
        for (r1 in 0 until N) {
            for (r2 in r1 + 1 until N) {
                for (c1 in 0 until M) {
                    for (c2 in c1 + 1 until M) {
                        val temp = (rowP[r1].last() + rowP[r2].last() + colP.last()[c1] + colP.last()[c2]) -
                                (d[r1][c1] + d[r1][c2] + d[r2][c1] + d[r2][c2]) +
                                (r2 - r1 - 1) * (c2 - c1 - 1)

                        answer = maxOf(answer, temp)
                    }
                }
            }
        }
        print(answer)
    }
}