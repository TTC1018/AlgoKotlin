package baekjoon.greedy


class `16206` {

    private var N = 0
    private var M = 0
    private var answer = 0

    private fun divideCount(q: List<Int>, tenFlag: Int = 1) {
        for (num in q) {
            if (M == 0)
                break

            when (num) {
                10 -> answer++
                else -> {
                    val need = num.div(10)
                    when {
                        need - tenFlag <= M -> {
                            answer += need
                            M -= (need - tenFlag)
                        }

                        else -> {
                            answer += M
                            M = 0
                        }
                    }
                }
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map(String::toInt)
            .also { N = it[0]; M = it[1] }
        val (prior, rest) = readLine().split(" ").map(String::toInt).sorted().partition { it % 10 == 0 }

        divideCount(prior)
        divideCount(rest, 0)

        print(answer)
    }

}

fun main() {

    `16206`().solution()

}