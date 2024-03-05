package baekjoon.greedy

class `20928` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val p = readLine().split(" ").map(String::toInt)
        val x = readLine().split(" ").map(String::toInt)
        // 단순 p-x 반복 탐색으로는 해결 불가능
        // 갈 수 있는 위치 중 가장 멀리 갈 수 있는 지점 선택
        var lastIdx = 1
        var reach = p.first() + x.first()
        var answer = 0
        while (reach < M) {
            val limit = reach
            for (i in lastIdx until N) {
                if (limit >= p[i]) {
                    reach = maxOf(reach, p[i] + x[i])
                } else {
                    lastIdx = i
                    break
                }
            }

            if (reach == limit) {
                print(-1)
                return
            }
            answer++
        }
        print(answer)
    }
}