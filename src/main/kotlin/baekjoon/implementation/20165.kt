package baekjoon.implementation

class `20165` {
    private data class Loc(
        val x: Int,
        val y: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M, R) = readLine().split(' ').map(String::toInt)
        val B = List(N) { readLine().split(" ").map(String::toInt) }
        val V = List(N) { CharArray(M) { 'S' } }
        val d = buildMap {
            put("E", Loc(0, 1)); put("W", Loc(0, -1))
            put("S", Loc(1, 0)); put("N", Loc(-1, 0))
        }
        var answer = 0
        repeat(R) {
            var (SX, SY) = 0 to 0
            var D = " "
            readLine().split(" ").run {
                SX = first().toInt() - 1; SY = this[1].toInt() - 1; D = last()
            }
            val (DX, DY) = readLine().split(" ").map { it.toInt() - 1 }
            var cnt = B[SX][SY]
            while (SX in 0 until N && SY in 0 until M && cnt > 0) {
                if (V[SX][SY] == 'S') {
                    answer++
                    cnt = maxOf(cnt - 1, B[SX][SY] - 1)
                } else {
                    cnt--
                }

                V[SX][SY] = 'F'
                SX += d[D]!!.x; SY += d[D]!!.y
            }
            V[DX][DY] = 'S'
        }

        print("$answer\n${V.joinToString("\n") { it.joinToString(" ") }}")
    }
}