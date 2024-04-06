package baekjoon.string

import java.math.BigInteger

class `1334` {
    // 12345 -> 12421
    // 858 -> 868
    // 1999 -> 2002
    // 9999 -> 10001
    // 12320 -> 12321
    fun main() = with(System.`in`.bufferedReader()) {
        val N = readLine().toBigInteger().plus(BigInteger.ONE) // N보다 큰수
        val S = N.toString()
        val L = S.length / 2
        var head = S.slice(0 until L)
        val tail = S.slice(L until S.length)
        if (S.length and 1 == 1)
            head += S[L]

        if (head.reversed().toBigInteger() >= tail.toBigInteger()) {
            print("$head${head.reversed().drop(S.length and 1)}")
        } else {
            print(
                head.let {
                    it.toBigInteger().plus(BigInteger.ONE).run {
                        "$this${toString().reversed().drop(S.length and 1)}"
                    }
                }
            )
        }
    }
}