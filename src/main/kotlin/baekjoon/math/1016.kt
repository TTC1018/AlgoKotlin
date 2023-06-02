package baekjoon.math

class `1016` {

    fun search(start: Long, end: Long): Long {

        val cnt = (end - start + 1)
        val checked = mutableSetOf<Long>()
        var num = 2L
        var startVal = if (start % (num*num) == 0L) start else (start.div(num * num) + 1) * num * num
        while (num*num <= end) {

            for (n in startVal..end step num*num) {
                checked.add(n)
            }

            num++
            startVal = if (start % (num*num) == 0L) start else (start.div(num * num) + 1) * num * num
        }

        return cnt - checked.size
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        val (minVal, maxVal) = readLine().split(" ").map { it.toLong() }
        print((search(minVal, maxVal)))

    }

}

fun main() {

    `1016`().solution()

}