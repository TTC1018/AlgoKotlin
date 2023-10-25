package baekjoon.binarysearch

class `14575` {
    private data class Parti(
        val l: Int,
        val r: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, T) = readLine().split(" ").map(String::toInt)
        val P = List(N) { readLine().split(" ").map(String::toInt).run { Parti(first(), last()) } }

        var answer = -1
        var (left, right) = 1 to T
        while (left <= right) {
            val s = (left + right).div(2)

            var (minVal, maxVal) = 0 to 0
            var satisfied = true
            for ((l, r) in P) {
                if (s >= l) {
                    maxVal += (minOf(s, r))
                    minVal += l
                } else {
                    satisfied = false
                    break
                }
            }

            if (satisfied && T in minVal..maxVal) {
                right = s - 1
                answer = s
            } else {
                left = s + 1
            }
        }
        print(answer)
    }
}