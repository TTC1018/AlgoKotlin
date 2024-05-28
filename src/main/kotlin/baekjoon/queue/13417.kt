package baekjoon.queue

class `13417` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            val N = readLine().toInt()
            val A = readLine().split(' ')
            val q = ArrayDeque<String>()
            for (a in A) {
                q.firstOrNull()?.let {
                    if (a <= it) {
                        q.addFirst(a)
                    } else {
                        q.addLast(a)
                    }
                } ?: run {
                    q.addLast(a)
                }
            }
            sb.appendLine(q.joinToString(""))
        }
        print(sb.dropLast(1))
    }
}