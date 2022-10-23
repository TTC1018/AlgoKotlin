package baekjoon.stack

class `10773` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val K = readLine().toInt()
        val stack = ArrayDeque<Long>()

        repeat(K) {
            val n = readLine().toLong()
            if (n != 0L) {
                stack.addLast(n)
            } else {
                stack.removeLast()
            }
        }

        println(stack.sumOf { it })
    }

}

fun main() {

    `10773`().solution()

}