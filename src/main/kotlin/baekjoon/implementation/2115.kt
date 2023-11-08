package baekjoon.implementation

class `2115` {
    private data class Step(
        val x: Int,
        val y: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (M, N) = readLine().split(" ").map(String::toInt)
        val B = List(M) { readLine() }
        // 많이 거는 방법?
        // 길이를 2로 나눈 만큼만 걸 수 있음
        // 일단 위가 X 아래가 .인 영역이 있는지 확인
        // 상하좌우 쭉 확인?
        val rowStep = listOf(Step(-1, 0), Step(1, 0))
        val colStep = listOf(Step(0, -1), Step(0, 1))
        var answer = 0
        for ((dx, dy) in rowStep) {
            for (i in 1 until M - 1) {
                var cnt = 0
                for (j in 1 until N - 1) {
                    if (B[i][j] == '.' && B[i+dx][j+dy] == 'X') {
                        cnt++
                    } else {
                        answer += cnt.div(2)
                        cnt = 0
                    }
                }
                answer += cnt.div(2)
            }
        }
        for ((dx, dy) in colStep) {
            for (j in 1 until N - 1) {
                var cnt = 0
                for (i in 1 until M - 1) {
                    if (B[i][j] == '.' && B[i+dx][j+dy] == 'X') {
                        cnt++
                    } else {
                        answer += cnt.div(2)
                        cnt = 0
                    }
                }
                answer += cnt.div(2)
            }
        }
        print(answer)
    }
}