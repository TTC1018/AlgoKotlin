package baekjoon.queue

class `27497` {
    private data class StringWithOrder(
        val order: Int,
        val s: Char,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val q = ArrayDeque<StringWithOrder>()
        var order = 0
        repeat(N) {
            order++
            val ops = readLine()
            when (ops.first()) {
                '1' -> {
                    val s = ops.last()
                    q.addLast(StringWithOrder(order, s))
                }

                '2' -> {
                    val s = ops.last()
                    q.addFirst(StringWithOrder(order, s))
                }

                '3' -> {
                    if (q.isNotEmpty()) {
                        if (q.first().order <= q.last().order) {
                            q.removeLast()
                        } else {
                            q.removeFirst()
                        }
                    }
                }
            }
        }
        print(if (q.isEmpty()) "0" else q.joinToString("") { it.s.toString() })
    }
}