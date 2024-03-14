package baekjoon.binarysearch

class `2428` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val F = readLine().split(" ").map(String::toDouble).sorted()

        var answer = 0L
        for (i in F.indices.reversed()) {
            val target = F[i] * 0.9
            var (l, r) = 0 to i - 1
            var temp = -1
            while (l <= r) {
                val m = (l + r).div(2)

                if (F[m] >= target) {
                    temp = m
                    r = m - 1
                } else {
                    l = m + 1
                }
            }

            if (temp != -1)
                answer += (i - temp)
        }
        print(answer)
    }
}