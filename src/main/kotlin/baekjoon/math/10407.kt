package baekjoon.math

class `10407` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val H = readLine()
        // 2^홀수 -> 2, 2^짝수 -> 1
        // 2 2^2 2^4 2^16 ... 처음을 제외하고 전부 짝수
        print(if (H == "2") 2 else 1)
    }
}