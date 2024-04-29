package baekjoon.greedy

class `25632` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val P = BooleanArray(1000 + 1) { true }.apply {
            this[0] = false
            this[1] = false
            for (n in 2..kotlin.math.sqrt(1000.0).toInt()) {
                for (i in 2..1000.div(n)) {
                    this[n * i] = false
                }
            }
        }
        val (A, B) = readLine().split(" ").map(String::toInt)
        val (C, D) = readLine().split(" ").map(String::toInt)
        val ytNum = (A..B).filter { P[it] }.toSet()
        val yjNum = (C..D).filter { P[it] }.toSet()
        val crossed = ytNum.intersect(yjNum)
        val isOdd = crossed.size % 2
        if (ytNum.size > yjNum.size - isOdd) {
            print("yt")
        } else {
            print("yj")
        }
    }
}