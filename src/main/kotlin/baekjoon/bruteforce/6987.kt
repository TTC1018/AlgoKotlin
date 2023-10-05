package baekjoon.bruteforce

class `6987` {
    private data class Match(
        val x: Int,
        val y: Int
    )

    private val match: List<Match> = buildList {
        for (x in 0 until 6) {
            for (y in x + 1 until 6) {
                add(Match(x, y))
            }
        }
    }
    private lateinit var R: List<IntArray>
    private lateinit var counter: List<IntArray>
    private val answer = IntArray(4)
    private var order = 0

    private fun isAnswer(): Int {
        for (i in 0 until 6) {
            for (j in 0 until 3) {
                if (R[i][j] != counter[i][j])
                    return 0
            }
        }
        return 1
    }

    private fun bruteforce(matchNum: Int) {
        if (matchNum == match.size) {
            answer[order] = maxOf(answer[order], isAnswer())
            return
        }

        val (x, y) = match[matchNum]
        // x 이기는 경우
        counter[x][0]++
        counter[y][2]++
        bruteforce(matchNum + 1)
        counter[x][0]--
        counter[y][2]--
        // 무승부
        counter[x][1]++
        counter[y][1]++
        bruteforce(matchNum + 1)
        counter[x][1]--
        counter[y][1]--
        // x 지는 경우
        counter[x][2]++
        counter[y][0]++
        bruteforce(matchNum + 1)
        counter[x][2]--
        counter[y][0]--
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        repeat(4) {
            order = it
            R = readLine().split(" ").chunked(3)
                .map { match -> match.map(String::toInt).toIntArray() }
            counter = List(6) { IntArray(3) }
            bruteforce(0)
        }
        print(answer.joinToString(" "))
    }
}

fun main() {
    `6987`().solution()
}