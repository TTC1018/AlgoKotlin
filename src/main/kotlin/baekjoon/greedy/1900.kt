package baekjoon.greedy

class `1900` {
    private data class Player(
        val p: Int,
        val r: Int,
    ) : Comparable<Player> {
        override fun compareTo(other: Player): Int {
            return (p + r * other.p).compareTo(other.p + other.r * p)
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val P = List(N) { readLine().split(" ").map(String::toInt).run { Player(first(), last()) } }
            .withIndex()
            .sortedByDescending { it.value }
        print(P.joinToString("\n") { "${it.index + 1}" })
    }
}