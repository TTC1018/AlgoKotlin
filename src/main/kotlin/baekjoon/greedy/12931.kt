package baekjoon.greedy

class `12931` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val B = readLine().split(" ").map(String::toInt).toIntArray()
        var answer = 0
        while (B.any { it > 0 }) {
            for (i in B.indices) {
                if (B[i] and 1 == 1) {
                    B[i]--
                    answer++
                }
            }

            if (B.any { it > 0 }) {
                answer++
                for (i in B.indices) {
                    B[i] /= 2
                }
            }
        }
        print(answer)
    }
}