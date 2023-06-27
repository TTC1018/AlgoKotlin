package baekjoon.stack

class `2504` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val S = readLine()
        var pCnt = 1
        val open = setOf('(', '[')
        val close = setOf(')', ']')
        val oppo = buildMap { put(')', '('); put(']', '[') }
        val nums = buildMap { put(')', 2); put('(', 2); put('[', 3); put(']', 3) }
        val stack = ArrayDeque<Char>()
        var answer = 0
        for (i in S.indices) {
            val s = S[i]
            when {
                s in open -> {
                    pCnt *= nums[s]!!
                    stack.add(s)
                }
                s in close -> {
                    if (stack.isEmpty() || stack.last() != oppo[s]) {
                        print(0)
                        return
                    }

                    if (S[i - 1] == oppo[s])
                        answer += pCnt

                    pCnt /= nums[s]!!
                    stack.removeLast()
                }
            }
        }

        if (stack.isNotEmpty())
            print(0)
        else
            print(answer)
    }
}

fun main() { `2504`().solution() }