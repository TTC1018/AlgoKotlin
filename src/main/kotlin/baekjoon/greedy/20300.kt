package baekjoon.greedy

class `20300` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val t = readLine().split(" ").map(String::toLong).sorted()
        // 합이 최소가 되려면 -> 작은값&큰값 짝을 이뤄야 됨, 낱개는 무조건 최댓값
        var answer = 0L
        if (t.size % 2 == 0) {
            var (l, r) = 0 to N - 1
            while (l < r) {
                answer = maxOf(answer, t[l] + t[r])
                l++; r--
            }
        } else {
            answer = t.last()
            var (l, r) = 0 to N - 2
            while (l < r) {
                answer = maxOf(answer, t[l] + t[r])
                l++; r--
            }
        }
        print(answer)
    }
}