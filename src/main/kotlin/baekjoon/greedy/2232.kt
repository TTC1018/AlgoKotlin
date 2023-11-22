package baekjoon.greedy

class `2232` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val P = buildList<Int> {
            add(0)
            repeat(N) {
                add(readLine().toInt())
            }
            add(0)
        }
        print(
            buildList {
                for (i in 1 .. N) {
                    if (P[i-1] <= P[i] && P[i] >= P[i+1])
                        add(i)
                }
            }.joinToString("\n")
        )
    }
}