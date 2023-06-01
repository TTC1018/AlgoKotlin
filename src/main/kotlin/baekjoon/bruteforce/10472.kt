package baekjoon.bruteforce

class `10472` {

    data class Loc(
        val x: Int,
        val y: Int
    )

    private lateinit var B: Array<CharArray>
    private var endFlag = false
    private val oppo = buildMap {
        put('*', '.')
        put('.', '*')
    }
    private val d = listOf(Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1))
    private val inRange: (Int, Int) -> Boolean = { x, y -> x in 0..2 && y in 0..2 }

    private fun whiteCheck(): Boolean {
        for (i in 0..2) {
            for (j in 0..2) {
                if (B[i][j] == '*')
                    return false
            }
        }
        return true
    }

    private fun switch(x: Int, y: Int) {
        B[x][y] = oppo[B[x][y]]!!
        for ((dx, dy) in d) {
            val nx = x + dx
            val ny = y + dy

            if (inRange(nx, ny))
                B[nx][ny] = oppo[B[nx][ny]]!!
        }
    }

    private fun bruteforce(idx: Int, cnt: Int, limit: Int) {
        if (idx == 9 || cnt == limit) {
            if (whiteCheck()) {
                println(cnt)
                endFlag = true
            }
            return
        }

        for (i in idx until 9) {
            if (endFlag)
                return
            val x = i / 3
            val y = i % 3

            // 바꾸기
            switch(x, y)
            bruteforce(i + 1, cnt + 1, limit)
            switch(x, y)

            // 안 바꾸기
            bruteforce(i + 1, cnt, limit)
        }
    }


    fun solution() = with(System.`in`.bufferedReader()) {

        val P = readLine().toInt()
        repeat(P) {

            B = Array(3) { readLine().toCharArray() }
            endFlag = false

            for (limit in 1..9) {
                bruteforce(0, 0, limit)
                if (endFlag)
                    break
            }

        }

    }

}

fun main() {

    `10472`().solution()

}