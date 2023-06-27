package baekjoon.graph

class `14395` {

    data class NumAndString(
        val num: Long,
        val signs: String
    )

    fun solution() = with(System.`in`.bufferedReader()) {

        val (s, t) = readLine().split(" ").map(String::toLong)

        if (s == t)
            print(0)
        else {
            val q = ArrayDeque<NumAndString>().apply { add(NumAndString(s, "")) }
            val answers = mutableListOf<String>()
            val visited = mutableSetOf<Long>().apply { add(s) }
            while (q.isNotEmpty()) {
                val (num, signs) = q.removeFirst()
                if (num == t) {
                    answers.add(signs)
                    continue
                }

                if (num * num <= 1e9 && num * num !in visited) {
                    visited.add(num * num)
                    q.add(NumAndString(num * num, "$signs*"))
                }
                if (num + num <= 1e9 && num + num !in visited) {
                    visited.add(num + num)
                    q.add(NumAndString(num + num, "$signs+"))
                }
                if (0 !in visited) {
                    visited.add(0)
                    q.add(NumAndString(0, "$signs-"))
                }
                if (1 !in visited) {
                    visited.add(1)
                    q.add(NumAndString(1, "$signs/"))
                }

            }

            if (answers.isEmpty())
                print(-1)
            else
                print(answers.minWith(compareBy({ it.length }, { it })))
        }
    }
}

fun main() { `14395`().solution() }