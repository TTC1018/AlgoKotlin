package baekjoon.math

class `30405` {
    fun solution() = with(System.`in`.bufferedReader()) {
        // 각 박물관 순회 거리는 고정
        // 결국 첫번째, 마지막 거리가 제일 중요
        val (N, M) = readLine().split(" ").map (String::toInt)
        val C = List(N) { readLine().split(" ").drop(1).map(String::toInt) }
        val cands = buildList {
            for (c in C) {
                add(c.first())
                add(c.last())
            }
        }.sorted()
        print(cands[N - 1])
    }
}