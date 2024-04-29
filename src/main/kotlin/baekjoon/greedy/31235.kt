package baekjoon.greedy

class `31235` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val A = readLine().split(" ").map(String::toInt)
        var answer = 1
        var len = 1
        var maxVal = A.first()
        for (i in 1 until N) {
            if (A[i] < maxVal) {
                len++
            } else {
                maxVal = A[i]
                answer = maxOf(answer, len)
                len = 1
            }
        }
        print(maxOf(answer, len))
    }
}