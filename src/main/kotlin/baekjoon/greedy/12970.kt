package baekjoon.greedy

class `12970` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        // i < j 인 AB 쌍
        // 앞에 있는 A의 개수에 따라 답이 달라짐
        // 최대값은 모든 A가 모조리 앞에 위치하는 것이다.
        // 즉, X * Y < K 인 경우에는 아예 불가능
        // X * Y >= K 인 경우를 조작해서 K를 만들어야 한다.
        // N = 10 K = 12인 경우
        // 가능한 경우 => 2 * 8, 3 * 7, 4 * 6, 5 * 5, 4 * 4
        // AABBBBBBBB 16
        // ABABBBBBBB 15
        // ABBABBBBBB 14
        // ...
        // ABBBBBBBBA 8
        for (i in 0..N) {
            val j = N - i // B개수
            if (K == i * j) {
                print("A".repeat(i) + "B".repeat(j))
                return
            }

            if (i * j >= K) {
                // 우측으로 보낼 A개수
                for (k in 1..i) {
                    val minVal = (i - k) * j
                    val maxVal = (i - k + 1) * j
                    if (K in minVal until maxVal) {
                        val cnt = maxVal - K
                        print(
                            "A".repeat(i - k) +
                                    "B".repeat(cnt) +
                                    "A" +
                                    "B".repeat(j - (k - 1) - cnt) +
                                    "A".repeat(k - 1)
                        )
                        return
                    }
                }
            }
        }

        print(-1)
    }
}

fun main() {
    `12970`().solution()
}