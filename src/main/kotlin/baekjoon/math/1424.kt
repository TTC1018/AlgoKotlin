package baekjoon.math

class `1424` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val L = readLine().toInt()
        val C = readLine().toInt()
        var perCd = 1
        while ((L + 1) * perCd + L <= C && perCd < N) {
            perCd++
        }
        if (perCd % 13 == 0)
            perCd--
        val base = N / perCd
        val left = N % perCd
        print(
            when {
                left == 0 -> base
                perCd - left == 1 && left % 13 == 0 -> base + 2
                else -> base + 1
            }
        )
    }
}