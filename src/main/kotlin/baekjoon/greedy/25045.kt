package baekjoon.greedy

class `25045` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val A = readLine().split(" ").map(String::toLong).sortedDescending()
        val B = readLine().split(" ").map(String::toLong).sorted()
        var (l, r) = 0 to 0
        var answer = 0L
        while (l < N && r < M) {
            if (A[l] < B[r]) {
                break
            }
            answer += (A[l] - B[r])
            l++; r++
        }
        print(answer)
    }
}