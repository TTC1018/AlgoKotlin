package baekjoon.string

import kotlin.math.pow

class `30446` {
    fun Double.p(num: Int) = pow(num).toInt()

    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine()
        val nNum = n.toLong()
        if (nNum < 10) {
            print(n)
            return
        }

        val nLen = n.length
        val half = nLen.div(2)
        var answer = 0L
        when (nLen % 2) {
            0 -> {
                for (i in (10.0).p(half - 1) until (10.0).p(half)) {
                    if ("$i${i.toString().reversed()}".toLong() > nNum)
                        break
                    answer++

                }
            }
            1 -> {
                for (i in (10.0).p(half - 1) until (10.0).p(half)) {
                    for (num in 0..9) {
                        if ("$i$num${i.toString().reversed()}".toLong() > nNum)
                            break
                        answer++
                    }
                }
            }
        }
        answer += listOf(9, 9, 90, 90, 900, 900, 9000, 9000, 90000, 90000, 900000)
            .slice(0 until nLen - 1)
            .sumOf { it }
        print(answer)
    }
}