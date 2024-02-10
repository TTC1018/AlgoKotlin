package baekjoon.greedy

class `17262` {
    private data class Fan(
        val s: Int,
        val e: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val F = List(N) { readLine().split(" ").map(String::toInt).run { Fan(first(), last()) } }
        print((F.run { maxOf { it.s } - minOf { it.e } }).coerceAtLeast(0))
    }
}