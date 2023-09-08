package baekjoon.graph

class `2310` {
    private enum class RoomType { E, L, T }

    private data class Room(
        val type: RoomType,
        val border: Int,
        val nexts: List<Int>,
    )

    private data class Loc(
        val now: Int,
        val left: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        loop@ while (true) {
            val n = readLine().toInt()
            if (n == 0)
                break

            val R = List(n) {
                readLine().split(" ").run {
                    Room(
                        RoomType.valueOf(this[0]),
                        this[1].toInt(),
                        drop(2).map { it.toInt() - 1 }.dropLast(1)
                    )
                }
            }

            val visited = IntArray(n) { -1 }
            val q = ArrayDeque<Loc>().apply {
                add(Loc(0, 0))
                visited[0] = 0
            }

            while (q.isNotEmpty()) {
                val (now, left) = q.removeFirst()
                if (now == n - 1) {
                    println("Yes")
                    continue@loop
                }

                for (next in R[now].nexts) {
                    when (R[next].type) {
                        RoomType.E -> {
                            if (left > visited[next]) {
                                visited[next] = left
                                q.add(Loc(next, left))
                            }
                        }

                        RoomType.L -> {
                            val added = maxOf(left, R[next].border)
                            if (added > visited[next]) {
                                visited[next] = added
                                q.add(Loc(next, added))
                            }
                        }

                        RoomType.T -> {
                            val paid = left - R[next].border
                            if (paid >= 0 && paid > visited[next]) {
                                visited[next] = paid
                                q.add(Loc(next, paid))
                            }
                        }
                    }
                }
            }

            println("No")
        }

    }
}

fun main() {
    `2310`().solution()
}