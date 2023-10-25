package baekjoon.stack

class `2374` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val A = List(n) { readLine().toLong() }
        val lastMinVal = ArrayDeque<Long>().apply {
            add(A.first())
        }
        var answer = 0L
        var maxVal = A.first()
        for (i in 1 until n) {
            if (lastMinVal.last() < A[i]) {
                // 나보다 작은 이전 숫자는 나와 동기화한다
                answer += (A[i] - lastMinVal.removeLast())
                lastMinVal.addLast(A[i])
            } else if (lastMinVal.last() > A[i]) {
                // 최솟값을 기록해두고 마지막에 최댓값에 동기화 시킬 것이다
                lastMinVal.removeLast()
                lastMinVal.addLast(A[i])
            }
            maxVal = maxOf(maxVal, A[i])
        }

        if (lastMinVal.isNotEmpty())
            answer += (maxVal - lastMinVal.last())
        print(answer)
    }
}

fun main() {
    `2374`().solution()
}