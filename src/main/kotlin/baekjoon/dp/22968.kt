package baekjoon.dp

class `22968` {
    fun solution() = with(System.`in`.bufferedReader()) {
        // 최소 개수의 정점으로 만들 수 있는 AVL 트리
        val dp = buildList<Long> {
            addAll(listOf(1, 2, 4))
            while (last() < 1000000000) {
                add(this[size - 2] + this[size - 1] + 1)
            }
        }

        print(
            buildList {
                repeat(readLine().toInt()) {
                    val V = readLine().toInt()
                    for (i in dp.indices) {
                        if (dp[i] > V) {
                            add(i)
                            break
                        }
                    }
                }
            }.joinToString("\n")
        )
    }
}