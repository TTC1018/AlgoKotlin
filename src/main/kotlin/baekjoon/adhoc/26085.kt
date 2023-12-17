package baekjoon.adhoc

class `26085` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val B = List(N) { readLine().split(" ").map(String::toInt) }
        val oneCnt = B.sumOf { it.count { n -> n == 1 } }
        val isEven = oneCnt % 2 == 0 && (N * M) % 2 == 0
        if (isEven.not()) { // 홀수개면 어차피 못 없앰
            print(-1)
            return
        }

        val dx = listOf(1, -1, 0, 0)
        val dy = listOf(0, 0, -1, 1)
        for (i in 0 until N) {
            for (j in 0 until M) {
                for (d in 0 until 4) {
                    val (nx, ny) = i + dx[d] to j + dy[d]
                    B.getOrNull(nx)
                        ?.getOrNull(ny)
                        ?.run {
                            // 짝수개면서 인접 카드와 동일하다면 빈공간 생기고 무조건 제거가능
                            if (B[i][j] == this) {
                                print(1)
                                return@with
                            }
                        }
                }
            }
        }
        print(-1)
    }
}