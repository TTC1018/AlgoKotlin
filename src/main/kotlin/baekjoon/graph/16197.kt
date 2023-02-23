package baekjoon.graph

class `16197` {

    data class Pos(
        val x: Int,
        val y: Int
    )

    data class Coins(
        val c1: Pos,
        val c2: Pos,
        val cnt: Int = 0
    )

    private val d = listOf(
        Pos(-1, 0), Pos(1, 0),
        Pos(0, -1), Pos(0, 1)
    )

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, M) = readLine().split(" ").map { it.toInt() }
        val board = Array(N) { readLine().toCharArray() }
        val inRange: (Int, Int) -> Boolean = { x, y -> x in 0 until N && y in 0 until M }

        val starts = mutableListOf<Pos>()
        for (i in 0 until N) {
            for (j in 0 until M) {
                if (board[i][j] == 'o'){
                    starts.add(Pos(i, j))
                    board[i][j] = '.'
                }
            }
        }

        val visited = mutableSetOf<Coins>()
        val q = ArrayDeque<Coins>().apply {
            val start = Coins(starts.first(), starts.last())
            add(start)
            visited.add(start)
        }

        while (q.isNotEmpty()) {
            val (c1, c2, cnt) = q.removeFirst()

            d.forEach { (dx, dy) ->
                val c1Nx = c1.x + dx
                val c1Ny = c1.y + dy
                val c2Nx = c2.x + dx
                val c2Ny = c2.y + dy

                val c1Range = inRange(c1Nx, c1Ny)
                val c2Range = inRange(c2Nx, c2Ny)
                if (c1Range xor c2Range){
                    if (cnt < 10){
                        print(cnt + 1)
                        return@with
                    }
                }
                else if (c1Range and c2Range){
                    if (cnt < 10){
                        val newC1 = if (board[c1Nx][c1Ny] == '#') c1 else Pos(c1Nx, c1Ny)
                        val newC2 = if (board[c2Nx][c2Ny] == '#') c2 else Pos(c2Nx, c2Ny)
                        val newCoins = Coins(newC1, newC2, cnt + 1)

                        if (newCoins !in visited){
                            visited.add(newCoins)
                            q.add(newCoins)
                        }
                    }
                }
            }
        }

        print(-1)
    }

}

fun main() {

    `16197`().solution()

}