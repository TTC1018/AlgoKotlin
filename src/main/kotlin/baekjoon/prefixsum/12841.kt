package baekjoon.prefixsum

class `12841` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val c = readLine().split(" ").map(String::toLong)
        val l = readLine().split(" ").map(String::toLong).toLongArray()
        val r = readLine().split(" ").map(String::toLong).toLongArray()
        for (i in 1 until n-1) {
            l[i] += l[i-1]
            r[i] += r[i-1]
        }

        var minNum = 0
        var minVal = c.first() + r.last()
        for (i in 0 until n-1) {
            val dist = l[i] + (r.last() - r[i]) + c[i+1]
            if (dist < minVal) {
                minNum = i+2
                minVal = dist
            }
        }
        print("$minNum $minVal")
    }
}

fun main() {
    `12841`().solution()
}