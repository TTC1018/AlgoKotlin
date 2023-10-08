package baekjoon.prefixsum

private const val START = 1999 * 12 + 12
private const val END = 9999 * 12 + 12

class `28070` {
    private val monthRetuner: (Int, Int) -> Int = { y, m ->
        y * 12 + m
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val S = IntArray(END - START + 1).apply {
            repeat(N) {
                readLine().split(" ").map { it.split("-").map(String::toInt) }
                    .let {
                        this[monthRetuner(it.first()[0], it.first()[1]) - START]++

                        if ((it.last()[0] == 9999 && it.last()[1] == 12).not())
                            this[monthRetuner(it.last()[0], it.last()[1]) + 1 - START]--
                    }
            }
        }.also {
            for (i in 1..(END - START)) {
                it[i] += (it[i - 1])
            }
        }

        val answer = (S.withIndex().maxBy { it.value }.index + START).run {
            Pair(div(12), mod(12).toString().padStart(2, '0'))
        }

        if (answer.second != "00")
            print("${answer.first}-${answer.second}")
        else
            print("${answer.first - 1}-12")
    }
}

fun main() {
    `28070`().solution()
}