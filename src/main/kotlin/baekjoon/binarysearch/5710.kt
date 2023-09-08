package baekjoon.binarysearch

import kotlin.math.absoluteValue

private const val FEE_1 = 2
private const val FEE_2 = 3
private const val FEE_3 = 5
private const val FEE_4 = 7

class `5710` {

    private val usageBorder = listOf(100, 10000, 1000000)
    private val costBorder = listOf(200, 29900, 4979900)

    private fun calcCost(usage: Int): Int {
        return when {
            usage <= usageBorder[0] -> usage * FEE_1
            usage <= usageBorder[1] -> costBorder[0] + (usage - usageBorder[0]) * FEE_2
            usage <= usageBorder[2] -> costBorder[1] + (usage - usageBorder[1]) * FEE_3
            else -> costBorder[2] + (usage - usageBorder[2]) * FEE_4
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        while (true) {
            val (A, B) = readLine().split(" ").map(String::toInt)
            if (A == 0 && B == 0)
                break

            // 사용량의 합 구하기
            val total = when {
                A <= costBorder[0] -> A.div(FEE_1)
                A <= costBorder[1] -> 1e2.toInt() + (A - costBorder[0]).div(FEE_2)
                A <= costBorder[2] -> 1e4.toInt() + (A - costBorder[1]).div(FEE_3)
                else -> 1e6.toInt() + (A - costBorder[2]).div(FEE_4)
            }

            var (left, right) = 1 to total.div(2)
            while (left <= right) {
                val mid = (left + right).div(2)
                val leftCost = calcCost(mid)
                val rightCost = calcCost(total - mid)

                val diff = (leftCost - rightCost).absoluteValue
                when {
                    diff == B -> {
                        println(leftCost)
                        break
                    }
                    diff > B -> left = mid + 1
                    diff < B -> right = mid - 1
                }
            }
        }
    }
}

fun main() {
    `5710`().solution()
}