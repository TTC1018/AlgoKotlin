package baekjoon.implementation

class `20006` {
    private data class Player(
        val l: Int,
        val n: String,
    ) {
        override fun toString(): String = "$l $n"
    }

    private data class Room(
        val s: Int,
        val e: Int,
        val players: List<Player>,
    ) {
        operator fun plus(other: Player) = Room(s, e, players + other)
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val (p, m) = readLine().split(" ").map(String::toInt)
        val P = List(p) { readLine().split(" ").run { Player(first().toInt(), last()) } }
        val R = mutableListOf<Room>()

        for (pl in P) {
            var inserted = false
            for (i in R.indices) {
                if (pl.l in R[i].s..R[i].e && R[i].players.size < m) {
                    R[i] = R[i] + pl
                    inserted = true
                    break
                }
            }

            if (inserted.not()) {
                R.add(Room(pl.l - 10, pl.l + 10, listOf(pl)))
            }
        }

        val sb = StringBuilder()
        for (r in R) {
            if (r.players.size == m) {
                sb.appendLine("Started!\n${r.players.sortedBy { it.n }.joinToString("\n")}")
            } else {
                sb.appendLine("Waiting!\n${r.players.sortedBy { it.n }.joinToString("\n")}")
            }
        }
        print(sb.dropLast(1))
    }
}