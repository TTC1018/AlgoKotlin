package baekjoon.bruteforce

import kotlin.math.absoluteValue

class `15661` {
    private var N = 0
    private lateinit var S: List<List<Int>>
    private var V = 0
    private var answer = Int.MAX_VALUE

    private fun Int.toBit() = (1 shl this)

    private fun bruteforce(idx: Int, cnt: Int, limit: Int) {
        if (cnt == limit) {
            answer = minOf(answer, calc())
            return
        }

        for (i in idx until N) {
            val bit = i.toBit()
            if (V and bit == 0) {
                V = V or bit
                bruteforce(i + 1, cnt + 1, limit)
                V = V xor bit
            }
        }
    }

    private fun calc(): Int {
        var s1 = 0
        var s2 = 0
        for (i in 0 until N) {
            val b1 = i.toBit()
            for (j in 0 until N) {
                val b2 = j.toBit()
                if (V and b1 > 0 && V and b2 > 0) {
                    s1 += S[i][j]
                } else if (V and b1 == 0 && V and b2 == 0) {
                    s2 += S[i][j]
                }
            }
        }

        return (s1 - s2).absoluteValue
    }

    fun main() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        S = List(N) { readLine().split(" ").map(String::toInt) }
        for (n in 2..N / 2) {
            bruteforce(0, 0, n)
        }
        print(answer)
    }
}