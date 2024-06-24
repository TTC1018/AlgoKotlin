package baekjoon.greedy

class `27740` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val A = readLine().split(" ").map(String::toInt)
        // 한 방향으로 가면 반대쪽의 1은 어떻게든 처리하긴 해야됨
        // 그래서 두 방향 중 돌아오는 길이가 짧은 쪽을 선택해야 됨

        // 나까지 있는 1을 왼쪽까지 다 소거시키는 데에 필요한 값
        val L = IntArray(N).apply {
            this[0] = A[0]
            for (i in 1 until N) {
                this[i] = if (A[i] == 1) i + 1 else this[i - 1]
            }
        }
        // 나까지 있는 1을 오른쪽까지 다 소거시키는 데에 필요한 값
        val R = IntArray(N).apply {
            this[lastIndex] = A.last()
            for (i in N - 2 downTo 0) {
                this[i] = if (A[i] == 1) N - i else this[i + 1]
            }
        }

        var answer = Int.MAX_VALUE
        var answerIdx = -1
        for (i in 0 until N) {
            val toLeft = L[i] // i까지의 1을 다 왼쪽으로 보낼 때
            val toRight = R.getOrElse(i + 1) { 0 } // 나머지 i+1 부터의 1을 다 오른쪽으로 보낼 때
            val sumVal = toLeft + toRight + minOf(toLeft, toRight) // 더 적게 돌아오는 쪽으로 가기
            if (sumVal < answer) {
                answer = sumVal
                answerIdx = i
            }
        }

        val lCnt = L[answerIdx]
        val rCnt = R.getOrElse(answerIdx + 1) { 0 }
        if (lCnt <= rCnt) {
            print("$answer\n${"L".repeat(lCnt) + "R".repeat(rCnt + lCnt)}")
        } else {
            print("$answer\n${"R".repeat(rCnt) + "L".repeat(lCnt + rCnt)}")
        }
    }
}