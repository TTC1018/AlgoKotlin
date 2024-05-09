package baekjoon.stack

class `1662` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val S = readLine()
        val stack = mutableListOf<Any>()
        for (i in S.indices) {
            when {
                S[i] == '(' -> stack.add('(')
                S[i] == ')' -> {
                    var sumVal = 0
                    while (stack.isNotEmpty() && stack.last() != '(') {
                        sumVal += stack.removeLast() as Int
                    }
                    stack.removeLast()
                    stack.add(stack.removeLast() as Int * sumVal)
                }
                S[i].isDigit() && S.getOrNull(i + 1) == '(' -> {
                    stack.add(S[i].digitToInt())
                }
                else -> stack.add(1)
            }
        }
        print(stack.sumOf { it as Int })
    }
}