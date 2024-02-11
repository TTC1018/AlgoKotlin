package baekjoon.greedy

class `5545` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val (A, B) = readLine().split(" ").map(String::toInt)
        val C = readLine().toInt()
        val T = List(N) { readLine().toInt() }.sortedDescending()
        // 토핑 가격 -> 모두 같음, 비싼 토핑부터 고르는 게 정답
        var totalCal = C
        var totalCost = A
        var answer = C / A
        for (i in 0 until N) {
            totalCost += B
            totalCal += T[i]
            answer = maxOf(answer, totalCal / totalCost)
        }
        print(answer)
    }
}