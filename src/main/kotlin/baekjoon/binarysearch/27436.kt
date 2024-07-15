package baekjoon.binarysearch

class `27436` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toLong()
        // 2칸 2~7 // 6
        // 3칸 8~19 // 12
        // 4칸 20~37 // 18
        // 5칸 38~61 // 24
        //    N = 3 * x(x+1)
        var answer = 0L
        var (l, r) = 1L to 2L * 1e9.toLong()
        while (l <= r) {
            val m = (l + r) / 2L

            if (N <= 3L * m * (m - 1) + 1L) {
                r = m - 1
                answer = m
            } else {
                l = m + 1
            }
        }
        print(answer)
    }
}