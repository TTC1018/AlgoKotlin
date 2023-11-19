package baekjoon.tree

class `20364` {
    private var N = 0
    private var Q = 0
    private lateinit var x: List<Int>
    private lateinit var T: BooleanArray
    private val answer = mutableListOf<Int>()

    private fun check(now: Int) {
        var num = now
        var first = -1
        while (num > 0) {
            if (T[num]) {
                first = num
            }
            num /= 2
        }
        if (first == -1) {
            T[now] = true
            answer.add(0)
        } else {
            answer.add(first)
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); Q = last()
        }
        x = List(Q) { readLine().toInt() }
        T = BooleanArray(N + 1) { false }

        for (xi in x) {
            check(xi)
        }
        print(answer.joinToString("\n"))
    }
}