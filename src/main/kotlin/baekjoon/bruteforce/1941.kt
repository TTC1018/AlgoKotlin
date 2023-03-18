package baekjoon.bruteforce

class `1941` {

    data class Pos(
        val x: Int,
        val y: Int
    )

    private lateinit var board: Array<CharArray>
    private val inRange: (Int, Int) -> Boolean = { x, y -> x in 0 until 5 && y in 0 until 5 }
    private val direc = listOf(Pos(1, 0), Pos(-1, 0), Pos(0, 1), Pos(0, -1))
    private val checked = mutableSetOf<Int>()
    private var answer = 0

    private fun search(bits: Int, sCnt: Int, yCnt: Int) {
        if (yCnt >= 4)
            return

        if (sCnt + yCnt == 7) {
            if (bits !in checked) {
                answer++
                checked.add(bits)
            }
            return
        }

        val binary = bits.toString(2).reversed()
        for (i in binary.indices){
            if (binary[i] == '1'){
                val x = i.div(5)
                val y = i.mod(5)
                for ((dx, dy) in direc){
                    val nx = x + dx
                    val ny = y + dy
                    val bit = 1 shl (nx * 5 + ny)

                    if (inRange(nx, ny) && (bits and bit) != bit) {
                        when (board[nx][ny]) {
                            'Y' -> search(bits or bit, sCnt, yCnt + 1)
                            'S' -> search(bits or bit, sCnt + 1, yCnt)
                        }
                    }
                }
            }
        }

    }

    fun solution() = with(System.`in`.bufferedReader()) {

        board = Array(5) { readLine().toCharArray() }
        for (i in 0 until 5) {
            for (j in 0 until 5) {
                if (board[i][j] == 'S') {
                    search(1 shl (i * 5 + j), 1, 0)
                }
            }
        }

        print(answer)
    }

}

fun main() {

    `1941`().solution()

}