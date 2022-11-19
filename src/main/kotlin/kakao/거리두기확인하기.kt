package kakao

const val LENGTH = 5

class Solution {

    data class Pos(
        val x: Int,
        val y: Int,
        val count: Int = 0
    )

    enum class Info(val data: Char) {
        EXAMINEE('P'), EMPTY('O'), PARTITION('X')
    }

    enum class Result {
        FAIL, SUCCESS
    }

    private val direc = listOf(
        Pos(1, 0), Pos(-1, 0),
        Pos(0, 1), Pos(0, -1)
    )

    private fun check(x: Int, y: Int, place: Array<String>): Result {
        val firstPos = Pos(x, y)
        val queue = ArrayDeque<Pos>().apply { add(firstPos) }
        val visited = Array(LENGTH) { BooleanArray(LENGTH) { false } }

        while (queue.isNotEmpty()) {

            val now = queue.removeFirst()

            for ((dx, dy) in direc){
                val nx = now.x + dx
                val ny = now.y + dy
                if (nx in 0 until LENGTH && ny in 0 until LENGTH){
                    val nextPos = Pos(nx, ny, now.count + 1)
                    if (visited[nx][ny].not()){
                        visited[nx][ny] = true
                        when (place[nx][ny]){
                            Info.EXAMINEE.data -> return Result.FAIL
                            Info.PARTITION.data -> continue
                            Info.EMPTY.data -> {
                                if (nextPos.count < 1)
                                    queue.addLast(nextPos)
                            }
                        }
                    }
                }
            }
        }

        return Result.SUCCESS
    }

    private fun search(place: Array<String>): Int {

        for (i in 0 until LENGTH) {
            for (j in 0 until LENGTH) {
                if (place[i][j] == Info.EXAMINEE.data) {
                    if (check(i, j, place) == Result.FAIL)
                        return Result.FAIL.ordinal
                }
            }
        }

        return Result.SUCCESS.ordinal
    }

    fun solution(places: Array<Array<String>>): IntArray {
        val answer = IntArray(LENGTH) { 0 }

        places.forEachIndexed { index, place ->
            answer[index] = search(place)
        }

        return answer
    }
}

fun main() {

    print(
        Solution().solution(
            arrayOf(
                arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
                arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
                arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
                arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
                arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP")
            )
        ).joinToString(" ")
    )

}