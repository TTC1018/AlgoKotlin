package baekjoon.binarysearch

class `19637` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val pMap = mutableMapOf<Long, String>().apply {
            repeat(N) {
                readLine().split(" ").run {
                    putIfAbsent(last().toLong(), first())
                }
            }
        }
        val C = List(M) { readLine().toInt() }
        val P = pMap.keys.toList()
        val sb = StringBuilder()
        for (c in C) {
            var (l, r) = 0 to P.size - 1
            var temp = r
            while (l <= r) {
                val m = (l + r).div(2)

                if (c <= P[m]) {
                    temp = m
                    r = m - 1
                } else {
                    l = m + 1
                }
            }
            sb.appendLine(pMap[P[temp]]!!)
        }
        print(sb.dropLast(1))
    }
}