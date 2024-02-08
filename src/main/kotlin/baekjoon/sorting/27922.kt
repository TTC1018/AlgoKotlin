package baekjoon.sorting

class `27922` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val L = List(N) { readLine().split(" ").map(String::toLong) }
        // 3개 중에 두개 고름
        // ab ac bc -> 3종류
        // ab, ac, bc 합 기준으로 정렬 후 K개 슬라이싱
        var answer = 0L
        for (i in 0 until 3) {
            for (j in i + 1 until 3) {
                answer = maxOf(
                    answer,
                    L.map { it[i] + it[j] }
                        .sortedDescending()
                        .slice(0 until K)
                        .sumOf { it }
                )
            }
        }
        print(answer)
    }

}