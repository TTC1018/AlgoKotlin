package baekjoon.queue

class `12186` {
    private data class Ticket(
        val s: String,
        val d: String,
    ) {
        override fun toString(): String = "$s-$d"
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            val N = readLine().toInt()
            val T = List(N) { Ticket(readLine(), readLine()) }
            val sMap = mutableMapOf<String, Ticket>()
            val dMap = mutableMapOf<String, Ticket>()
            for (t in T) {
                sMap[t.s] = t
                dMap[t.d] = t
            }
            val order = ArrayDeque<Ticket>().apply {
                T.first().run {
                    add(this)
                    sMap.remove(s)
                    dMap.remove(d)
                }
            }
            while (sMap.isNotEmpty() || dMap.isNotEmpty()) {
                val head = order.first()
                val tail = order.last()
                val nextHead = dMap[head.s]
                val nextTail = sMap[tail.d]

                nextHead?.run {
                    order.addFirst(this)
                    dMap.remove(d)
                    sMap.remove(s)
                }
                nextTail?.run {
                    order.addLast(this)
                    sMap.remove(s)
                    dMap.remove(d)
                }
            }
            sb.appendLine("Case #${it + 1}: ${order.joinToString(" ")}")
        }
        print(sb.dropLast(1))
    }
}