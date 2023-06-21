package baekjoon.bruteforce

class `20166` {

    private data class Loc(
        val x: Int,
        val y: Int
    )

    private var N = 0
    private var M = 0
    private var K = 0
    private lateinit var B: Array<CharArray>
    private lateinit var S: Array<String>
    private lateinit var sMap: MutableMap<String, Int>
    private val d = listOf(
        Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1),
        Loc(1, 1), Loc(1, -1), Loc(-1, 1), Loc(-1, -1)
    )
    private val chars = StringBuilder()

    private fun bruteforce(x: Int, y: Int, cnt: Int) {
        if (cnt > 5)
            return

        val s = chars.toString()
        if (s in sMap)
            sMap[s] = sMap.getOrDefault(s, 0) + 1

        for ((dx, dy) in d) {
            val nx = (x + dx).mod(N)
            val ny = (y + dy).mod(M)

            chars.append(B[nx][ny])
            bruteforce(nx, ny, cnt + 1)
            chars.deleteCharAt(chars.length - 1)
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map(String::toInt)
            .also { N = it[0]; M = it[1]; K = it[2] }
        B = Array(N) { readLine().toCharArray() }
        S = Array(K) { readLine() }
        sMap = buildMap { S.forEach { put(it, 0) } }.toMutableMap()

        for (i in 0 until N) {
            for (j in 0 until M) {
                chars.append(B[i][j])
                bruteforce(i, j, 1)
                chars.clear()
            }
        }

        print(S.map { sMap[it] }.joinToString("\n"))
    }

}

fun main() {

    `20166`().solution()

}