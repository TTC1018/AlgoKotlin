package baekjoon.math

class `14232` {
    fun solution() = with(System.`in`.bufferedReader()) {
        var k = readLine().toLong()
        var answer = 0
        val sb = StringBuilder()
        for (n in 2..kotlin.math.sqrt(k.toDouble()).toInt()) {
            while (k % n == 0L) {
                k /= n
                answer++
                sb.append("$n ")
            }
        }

        if (k > 1) {
            answer++
            sb.append("$k ")
        }
        print("$answer\n${sb.dropLast(1)}")
    }
}