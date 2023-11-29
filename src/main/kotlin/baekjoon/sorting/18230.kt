package baekjoon.sorting

class `18230` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, A, B) = readLine().split(" ").map(String::toInt)
        val TO = readLine().split(" ").map(String::toLong).sortedDescending()
        val TT = readLine().split(" ").map(String::toLong).sortedDescending()
        // N이 짝수면 -> 2x1두개 vs. 2x2 한개
        // N이 홀수면 -> 2x2+2x1 vs. 2x1 3개 한번만 비교하고 나머지 다 짝수처럼
        var answer = 0L
        var cnt = 0
        var (oPtr, tPtr) = 0 to 0
        if (N % 2 == 1) {
            if (N == 1) {
                print(TO.first())
                return
            } else {
                val oSum = TO.first() + TO.getOrElse(1) { 0 } + TO.getOrElse(2) { Long.MIN_VALUE }
                val tSum = TT.first() + TO.first()
                if (oSum > tSum) {
                    oPtr += 3
                    answer += oSum
                } else {
                    tPtr += 1
                    oPtr += 1
                    answer += tSum
                }
                cnt += 3
            }
        }
        while (cnt < N) {
            val oBlocks = TO.getOrElse(oPtr) { 0 } + TO.getOrElse(oPtr + 1) { Long.MIN_VALUE }
            val tBlock = TT.getOrElse(tPtr) { Long.MIN_VALUE }

            if (oBlocks > tBlock) {
                answer += oBlocks
                oPtr += 2
            } else {
                answer += tBlock
                tPtr++
            }
            cnt += 2
        }
        print(answer)
    }
}