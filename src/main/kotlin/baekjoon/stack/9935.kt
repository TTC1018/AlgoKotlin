package baekjoon.stack

class `9935` {

    fun solution() = with(System.`in`.bufferedReader()) {
        var S = readLine()
        val T = readLine().toList()

        val stack = ArrayDeque<Char>()
        for (s in S) {
            stack.add(s)
            if (stack.size >= T.size &&
                stack.last() == T.last() &&
                stack.slice(stack.size - T.size until stack.size) == T)
                repeat(T.size) { stack.removeLast() }
        }
        print(stack.joinToString("").ifEmpty { "FRULA" })
    }

}

fun main() { `9935`().solution() }