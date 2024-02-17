package baekjoon.queue

class `29813` {
    private data class Student(
        val initial: String,
        val num: String,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val q = ArrayDeque<Student>().apply {
            repeat(N) {
                add(readLine().split(" ").run { Student(first(), last()) })
            }
        }

        while (q.size > 1) {
            val (_, num) = q.removeFirst()

            repeat(num.toInt() - 1) {
                q.addLast(q.removeFirst())
            }
            q.removeFirst()
        }
        print(q.removeFirst().initial)
    }
}