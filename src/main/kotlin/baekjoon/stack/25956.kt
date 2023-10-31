package baekjoon.stack

class `25956` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val I = List(N) { readLine().toInt() }.reversed()
        if (I.last() != 1 || I.zipWithNext().any { (p, n) -> p - n > 1 }) {
            print(-1)
            return
        }

        val answer = IntArray(N)
        val stack = mutableListOf<Int>()
        for (i in I.indices) {
            while (stack.isNotEmpty() && stack.last() - 1 == I[i]) {
                answer[i]++
                stack.removeLast()
            }

            stack.add(I[i])
        }
        print(answer.reversed().joinToString("\n"))
    }
}