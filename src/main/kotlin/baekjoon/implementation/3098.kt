package baekjoon.implementation

class `3098` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        var checked = 0
        var day = 1
        val G = List(N) { IntArray(N) { Int.MAX_VALUE } }.apply {
            repeat(M) {
                val (A, B) = readLine().split(" ").map { it.toInt() - 1 }
                this[A][B] = 1
                this[B][A] = 1
                checked++
            }
        }

        val answer = mutableListOf<Int>()
        val edgeCnt = N * (N - 1) / 2
        while (checked < edgeCnt) {
            day++
            var temp = 0
            for (i in G.indices) {
                for (j in G.indices) {
                    if (G[i][j] < day) {
                        for (k in i + 1 until N) {
                            if (G[j][k] < day && G[i][k] == Int.MAX_VALUE) {
                                G[i][k] = day
                                G[k][i] = day
                                temp++
                            }
                        }
                    }
                }
            }

            checked += temp
            answer.add(temp)
        }
        print(
            answer.run {
                var result = "$size"
                if (answer.size > 0)
                    result += "\n${answer.joinToString("\n")}"
                result
            }
        )
    }
}