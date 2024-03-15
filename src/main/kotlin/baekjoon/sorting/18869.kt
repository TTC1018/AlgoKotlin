package baekjoon.sorting

class `18869` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (M, N) = readLine().split(" ").map(String::toInt)
        val S = List(M) {
            readLine().split(" ").map(String::toInt).distinct().withIndex()
                .sortedBy { it.value }.map { it.index }
        }

        var answer = 0
        for (i in 0 until M) {
            for (j in i + 1 until M) {
                if (S[i] == S[j])
                    answer++
            }
        }
        print(answer)
    }
}