package baekjoon.queue

class `20956` {
    private data class IceCream(
        val a: Int,
        val i: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val ic = readLine().split(" ").mapIndexed { i, a -> IceCream(a.toInt(), i) }
            .groupBy { it.a }
            .toSortedMap(reverseOrder())
        val A = List(ic.keys.size) { ArrayDeque<IceCream>() }.apply {
            ic.keys.forEachIndexed { i, a ->
                this[i].addAll(ic[a]!!.sortedBy { it.i })
            }
        }

        var reverseFlag = false
        var ptr = 0
        val answer = mutableListOf<Int>()
        while (answer.size < M) {
            val target = if (reverseFlag.not()) {
                A[ptr].removeFirst()
            } else {
                A[ptr].removeLast()
            }

            answer.add(target.i+1)
            if (target.a % 7 == 0) {
                reverseFlag = reverseFlag.not()
            }
            if (A[ptr].size == 0) {
                ptr++
            }
        }
        print(answer.joinToString("\n"))
    }

}