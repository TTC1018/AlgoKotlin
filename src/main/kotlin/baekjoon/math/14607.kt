package baekjoon.math

class `14607` {
    private var answer = 0L

    private fun split(now: Long) {
        if (now == 1L)
            return

        if (now == 2L) {
            answer++
            return
        }

        val left = now.floorDiv(2)
        val right = if (now and 1L == 1L) left + 1 else left
        answer += left * right
        split(left)
        split(right)
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        split(readLine().toLong())
        print(answer)
    }
}