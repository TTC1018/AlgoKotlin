package baekjoon.sorting

class `2790` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val D = List(N) { readLine().toInt() }.sortedDescending()
        var maxVal = D.first()+1
        var answer = 1
        for (i in 1 until N) {
            if (maxVal <= D[i]+N) {
                answer++
            }
            maxVal = maxOf(maxVal, D[i]+i+1)
        }
        print(answer)
    }
}