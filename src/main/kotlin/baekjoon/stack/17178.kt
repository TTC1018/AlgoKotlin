package baekjoon.stack

class `17178` {
    private data class Ticket(
        val a: String,
        val n: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (other !is Ticket)
                return false
            return a == other.a && n == other.n
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val T = List(N) {
            readLine().trim().split(" ").map {
                it.split('-').run { Ticket(first(), last().toInt()) }
            }
        }.flatten()
        val O = ArrayDeque<Ticket>().apply {
            addAll(T.sortedWith(compareBy({ it.a }, { it.n })))
        }

        val stack = mutableListOf<Ticket>()
        for (t in T) {
            stack.add(t)

            while (O.isNotEmpty() && O.first() == stack.lastOrNull()) {
                O.removeFirst()
                stack.removeLast()
            }
        }

        if (O.reversed().run { size == stack.size && zip(stack).all { (p, n) -> p == n } }) {
            print("GOOD")
        } else {
            print("BAD")
        }
    }
}