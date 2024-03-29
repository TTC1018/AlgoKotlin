package baekjoon.stack

class `15815` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val S = readLine()
        val stack = mutableListOf<Int>()
        for (s in S) {
            with(stack) {
                add(
                    when (s) {
                        '+' -> removeLast() + removeLast()
                        '-' -> removeLast().let { removeLast() - it }
                        '*' -> removeLast() * removeLast()
                        '/' -> removeLast().let { removeLast() / it }
                        else -> s.digitToInt()
                    }
                )
            }
        }
        print(stack.removeLast())
    }
}