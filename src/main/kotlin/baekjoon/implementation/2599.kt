package baekjoon.implementation

class `2599` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val (a1, a2) = readLine().split(" ").map(String::toInt)
        val (b1, b2) = readLine().split(" ").map(String::toInt)
        val (c1, c2) = readLine().split(" ").map(String::toInt)

        for (ab in 0..a1) {
            val answer = mutableListOf<Int>()
            val ac = a1 - ab
            val ba = c2 - ac
            val bc = b1 - ba
            val ca = a2 - bc
            val cb = c1 - ca
            answer.addAll(listOf(ab, ac, bc, ba, ca, cb))
            if (answer.all { it >= 0 }) {
                print("1\n${answer.chunked(2).joinToString("\n") { it.joinToString(" ") }}")
                return
            }
        }
        print(0)
    }
}