package baekjoon.greedy

class `23322` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        // 초콜릿 최대한 먹기 -> 큰거 계속 먹기
        val a = readLine().split(" ").map(String::toInt)

        val minVal = a.first()
        var ptr = N-1
        var answer = 0
        var cnt = 0
        while (ptr > 0) {
            val take = a[ptr] - minVal
            if (take != 0) {
                answer += take
                cnt++
            } else {
                break
            }

            ptr--
        }
        print("$answer $cnt")
    }
}