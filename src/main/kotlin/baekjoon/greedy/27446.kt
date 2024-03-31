package baekjoon.greedy

class `27446` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val D = readLine().split(" ").map(String::toInt).toSet()
        var lastNum = 0
        var answer = 0
        for (n in 1..N) {
            if (n !in D) {
                if (lastNum == 0) {
                    answer += 7
                } else {
                    answer += minOf(7, (n - lastNum) * 2)
                }
                lastNum = n
            }
        }
        print(answer)
    }
}