package baekjoon.sorting

class `2107` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val P = List(N) { readLine().split(" ").map(String::toInt) }
            .sortedWith(compareBy({ it[0] }, { it[1] }))

        var answer = 0
        for (i in 0 until N) {
            var cnt = 0
            for (j in i + 1 until N) {
                if (P[i][1] > P[j][1])
                    cnt++
                else if (P[i][1] <= P[j][0])
                    break
            }
            answer = maxOf(answer, cnt)
        }
        print(answer)
    }
}