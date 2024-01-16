package baekjoon.greedy

class `11918` {
    private data class Range(
        val s: Long,
        val e: Long,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, L) = readLine().trim().split(" ").map(String::toInt)
        val SL = readLine().trim().split(" ").map(String::toLong)
            .sorted().map { Range(it-L, it+L) }
        // 모든 가로등이 양쪽으로 L만큼 빛을 비춤
        // 어떤 경우에도 빛이 있는 지점의 길이 구하기
        var prev = SL.first().s
        var answer = 0L
        for (i in 1 until N) {
            if (SL[i-1].e > SL[i].s) { // 겹치는 상황
                // 꺼도 살아남는 영역 더하기
                answer += (SL[i-1].e - maxOf(prev, SL[i].s))
            }
            prev = SL[i-1].e
        }
        print(answer)
    }
}