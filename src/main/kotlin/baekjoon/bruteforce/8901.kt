package baekjoon.bruteforce

class `8901` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        for (t in 0 until readLine().toInt()) {
            val (A, B, C) = readLine().split(" ").map(String::toInt)
            val (AB, BC, CA) = readLine().split(" ").map(String::toInt)

            var answer = 0
            for (ab in 0..minOf(A, B)) {
                val (aLeft, bLeft) = A - ab to B - ab
                for (bc in 0..minOf(bLeft, C)) {
                    val cLeft = C - bc
                    answer = maxOf(answer, ab * AB + bc * BC + minOf(aLeft, cLeft) * CA)
                }
            }
            sb.appendLine(answer)
        }
        print(sb.dropLast(1))
    }
}