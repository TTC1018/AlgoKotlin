package baekjoon.dp

class `17351` {
    private data class Step(
        val x: Int,
        val y: Int
    )

    private val d = listOf(
        Step(1, 0), Step(0, 1)
    )

    private var N = 0
    private lateinit var B: List<String>
    private lateinit var counter: List<List<IntArray>>
    private val next = buildMap {
        "MOLA".zipWithNext { p, n -> put(p, n) }
    }

    private fun dfs(x: Int, y: Int, cnt: Int): Int {
        if (x == N - 1 && y == N - 1)
            return 0
        if (counter[x][y][cnt] != -1)
            return counter[x][y][cnt]

        d.forEach { (dx, dy) ->
            val (nx, ny) = x + dx to y + dy
            if (nx in 0 until N && ny in 0 until N) {
                val target = B[nx][ny]
                counter[x][y][cnt] = when {
                    target == 'M' -> {
                        maxOf(counter[x][y][cnt], dfs(nx, ny, 1))
                    }

                    target == 'O' && cnt == 1 -> {
                        maxOf(counter[x][y][cnt], dfs(nx, ny, 2))
                    }

                    target == 'L' && cnt == 2 -> {
                        maxOf(counter[x][y][cnt], dfs(nx, ny, 3))
                    }

                    target == 'A' && cnt == 3 -> {
                        maxOf(counter[x][y][cnt], dfs(nx, ny, 0) + 1)
                    }

                    else -> maxOf(counter[x][y][cnt], dfs(nx, ny, 0))
                }
            }
        }

        return counter[x][y][cnt]
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        B = List(N) { readLine() }
        counter = List(N) { List(N) { IntArray(3 + 1) { -1 } } }
        print(dfs(0, 0, if (B[0][0] == 'M') 1 else 0))
    }
}

fun main() {
    `17351`().solution()
}