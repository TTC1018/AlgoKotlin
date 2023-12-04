package baekjoon.twopointer

class `14246` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val a = readLine().split(" ").map(String::toInt)
        val k = readLine().toInt()
        var answer = 0L
        for (l in 0 until n) {
            var r = l
            var sumVal = 0L
            while (r < n) {
                sumVal += a[r]
                if (sumVal > k) {
                    answer += (n - r)
                    break
                }
                r++
            }
        }
        print(answer)
    }
}