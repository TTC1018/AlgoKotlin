package baekjoon.bruteforce

class `25401_2` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val x = readLine().split(" ").map(String::toInt)
        var answer = Int.MAX_VALUE
        for (i in x.indices) {
            for (j in i + 1 until N) {
                val dist = j - i
                val diff = x[j] - x[i]
                if (diff % dist == 0) {
                    val perDiff = diff / dist
                    val s = x[i] - i * perDiff
                    var idx = -1
                    answer = minOf(answer, x.count { s + (perDiff * ++idx) != it })
                }
            }
        }
        print(answer)
    }
}