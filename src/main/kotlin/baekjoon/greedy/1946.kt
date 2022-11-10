package baekjoon.greedy

class `1946` {

    data class Worker(
        val resume: Int,
        val interview: Int
    )

    fun solution() = with(System.`in`.bufferedReader()) {

        val T = readLine().toInt()
        repeat(T) {

            val N = readLine().toInt()
            val workers = mutableListOf<Worker>().apply {
                repeat(N) {
                    val (r, i) = readLine().split(" ").map { it.toInt() }
                    add(Worker(r, i))
                }
            }

            workers.sortBy { it.resume }
            var deadline = workers.first().interview
            var answer = 1
            for (i in 1 until N) {
                if (deadline > workers[i].interview){
                    answer++
                    deadline = workers[i].interview
                }
            }


            println(answer)
        }

    }

}

fun main() {

    `1946`().solution()

}