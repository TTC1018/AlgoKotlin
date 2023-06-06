package baekjoon

import kotlin.math.max

class `16472` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val S = readLine()

        val types = mutableMapOf<Char, Int>().apply { put(S[0], 1) }
        var left = 0
        var right = 0
        var answer = 0
        while (right < S.length) {
            if (types.size > N) {
                types[S[left]] = types.getOrDefault(S[left], 0) - 1
                if (types[S[left]]!! <= 0)
                    types.remove(S[left])

                if (left == right) {
                    right++
                    if (right == S.length)
                        break
                    types[S[right]] = types.getOrDefault(S[right], 0) + 1
                }
                left++
            }
            else {
                answer = max(answer, right - left + 1)
                right++
                if (right == S.length)
                    break

                types[S[right]] = types.getOrDefault(S[right], 0) + 1
            }
        }

        print(answer)
    }

}

fun main() {

    `16472`().solution()

}