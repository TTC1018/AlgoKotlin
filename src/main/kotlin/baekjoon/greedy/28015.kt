package baekjoon.greedy

class `28015` {
    private var N = 0
    private var M = 0
    private lateinit var B: List<List<Int>>

    private fun calc(x: Int, y: Int, e: Int): Int {
        var a1 = if (B[x][y] == 1) 1 else 0
        var a2 = if (B[x][y] == 2) 1 else 0
        for (j in y + 1..e) {
            if (B[x][j] != B[x][j - 1]) {
                if (B[x][j] == 1) {
                    a1++
                } else {
                    a2++
                }
            }
        }
        return 1 + minOf(a1, a2) // 최소 1번 + 1과2중 최소 횟수 누적
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        // 행으로만 칠할 수 있음
        // 색 두가지 존재 (1, 2)
        // 덧칠이 가능하기 때문에 1,2로 연결된 부분은 한번에 칠하기
        // 내부 다른 색 칠하기
        readLine().split(" ").map(String::toInt).run {
            N = first(); M = last()
        }
        B = List(N) { readLine().split(" ").map(String::toInt) }
        var answer = 0
        for (i in 0 until N) {
            var sIdx = -1
            for (j in 0 until M) {
                if (B[i][j] == 0) { // 끊기는 경우
                    if (sIdx != -1) {
                        answer += calc(i, sIdx, j - 1)
                    }
                    sIdx = -1
                } else { // 이어가도 되는 경우
                    if (sIdx == -1) {
                        sIdx = j
                    }
                }
            }

            if (sIdx != -1)
                answer += calc(i, sIdx, M - 1)
        }
        print(answer)
    }
}