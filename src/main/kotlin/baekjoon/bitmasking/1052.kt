package baekjoon.bitmasking

class `1052` {
    fun solution() = with(System.`in`.bufferedReader()) {
        var (N, K) = readLine().split(" ").map(String::toInt)
        var answer = 0
        while (true) {
            if (N.countOneBits() <= K) {
                print(answer)
                return
            }
            N++
            answer++
        }
    }
}