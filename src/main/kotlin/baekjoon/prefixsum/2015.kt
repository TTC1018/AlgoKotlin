package baekjoon.prefixsum

class `2015` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val A = readLine().split(" ").map(String::toLong)
        val P = LongArray(N).apply {
            this[0] = A.first()
            for (i in 1 until N) {
                this[i] += this[i - 1] + A[i]
            }
        }
        val pMap = mutableMapOf<Long, Int>()
        var answer = 0L
        for (p in P) {
            if (p == K.toLong())
                answer++

            // 순차탐색하므로 이것보다 위의 누적합은 맵에 기록돼있지 않음
            answer += pMap.getOrDefault(p - K, 0)
            pMap[p] = pMap.getOrDefault(p, 0) + 1
        }
        print(answer)
    }
}