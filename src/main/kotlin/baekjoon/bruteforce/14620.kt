package baekjoon.bruteforce

class `14620` {
    private data class Loc(
        val x: Int,
        val y: Int,
    )

    private var N = 0
    private lateinit var B: List<List<Int>>
    private lateinit var C: List<BooleanArray>
    private var answer = Int.MAX_VALUE
    private var temp = 0
    private val d = listOf(
        Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1), Loc(0, 0)
    )

    private fun bruteforce(x: Int, y: Int, cnt: Int) {
        if (cnt == 3) {
            answer = minOf(answer, temp)
            return
        }

        for (i in x until N - 1) {
            for (j in y until N - 1) {
                if (d.all { (dx, dy) -> C[i+dx][j+dy].not() }) {
                    d.forEach { (dx, dy) -> C[i+dx][j+dy] = true; temp += B[i+dx][j+dy] }
                    bruteforce(x, y, cnt + 1)
                    d.forEach { (dx, dy) -> C[i+dx][j+dy] = false; temp -= B[i+dx][j+dy] }
                }
            }
        }
    }

    fun main() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        B = List(N) { readLine().split(" ").map(String::toInt) }
        C = List(N) { BooleanArray(N) { false } }

        bruteforce(1, 1, 0)
        print(answer)
    }
}