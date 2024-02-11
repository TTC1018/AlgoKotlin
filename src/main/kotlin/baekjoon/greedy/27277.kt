package baekjoon.greedy

class `27277` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val a = readLine().split(" ").map(String::toLong)
            .sorted()
        // 첫번째 -> 그대로 반영
        // 이전 병사와의 차이만큼 발휘
        // 6 1 5 2 4 3
        // 6 1 5 2 4
        var answer = a.last()
        var (l, r) = 0 to N - 2
        while (l < r) {
            answer += a[r] - a[l]
            r--
            l++
        }
        print(answer)
    }
}