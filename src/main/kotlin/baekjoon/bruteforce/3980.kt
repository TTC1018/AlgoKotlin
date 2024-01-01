package baekjoon.bruteforce

class `3980` {
    private lateinit var P: List<List<Int>>
    private var answer = 0
    private var visited = 0

    private fun Int.toBit() = 1 shl this

    private fun bruteforce(idx: Int, total: Int) {
        if (idx == P.size) {
            answer = maxOf(answer, total)
            return
        }

        for (j in 0 until 11) {
            if (P[idx][j] != 0 && visited and j.toBit() == 0) {
                visited = visited or j.toBit()
                bruteforce(idx + 1, total + P[idx][j])
                visited = visited xor j.toBit()
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            P = List(11) { readLine().split(" ").map(String::toInt) }
            answer = 0
            bruteforce(0, 0)
            sb.append(answer).append('\n')
        }
        print(sb.dropLast(1))
    }
}