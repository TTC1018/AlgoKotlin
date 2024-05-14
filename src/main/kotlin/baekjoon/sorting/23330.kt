package baekjoon.sorting

class `23330` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val x = readLine().split(" ").map(String::toLong).sorted()
        var answer = 0L
        var (l, r) = 0 to n - 1
        while (l < r) {
            answer += 2 * (x[r] - x[l]) * (r-- - l++)
        }
        print(answer)
    }
}