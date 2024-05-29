package baekjoon.twopointer

class `24508` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K, T) = readLine().split(" ").map(String::toInt)
        val A = readLine().split(" ").map(String::toInt).filter { it > 0 }
            .toIntArray()
            .sortedArray()
        var t = T
        var (l, r) = 0 to A.lastIndex
        while (l < r && t > 0) {
            val need = K - A[r]
            val plus = minOf(A[l], need)

            if (A[r] + plus < K) {
                A[r] += plus
            } else {
                r--
            }

            if (A[l] - plus == 0) {
                l++
            } else {
                A[l] -= plus
            }

            t -= plus
        }

        if (l <= r || t < 0) {
            print("NO")
        } else {
            print("YES")
        }
    }
}