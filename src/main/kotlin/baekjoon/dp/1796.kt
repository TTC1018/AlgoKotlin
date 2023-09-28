package baekjoon.dp

import kotlin.math.absoluteValue

class `1796` {
    fun solution() = with(System.`in`.bufferedReader()) {
        // 알파벳 순서대로 출력 -> 현재 가장 가까운 알파벳에서 먼 알파벳까지 가는게 경제적
        val S = readLine()
        val leftMap = mutableMapOf<Char, Int>()
        val rightMap = mutableMapOf<Char, Int>()
        for (i in S.indices) {
            leftMap[S[i]] = minOf(i, leftMap.getOrDefault(S[i], Int.MAX_VALUE))
            rightMap[S[i]] = maxOf(i, rightMap.getOrDefault(S[i], -1))
        }

        val alphas = leftMap.keys.sorted()
        val dp = List(alphas.size) { IntArray(2) }.apply {
            val (left, right) = leftMap[alphas.first()]!! to rightMap[alphas.first()]!!
            val dist = right - left
            this[0][0] = right + dist // 원점 -> 가장 오른쪽 위치 -> 가장 왼쪽 위치
            this[0][1] = left + dist // 원점 -> 가장 왼쪽 위치 -> 가장 오른쪽 위치
        }

        for (i in 1 until alphas.size) {
            val (prevL, prevR) = leftMap[alphas[i - 1]]!! to rightMap[alphas[i - 1]]!!
            val (l, r) = leftMap[alphas[i]]!! to rightMap[alphas[i]]!!
            val dist = r - l

            // 1. 이전 알파벳 가장 왼쪽 위치 -> 가장 오른쪽 위치 -> 가장 왼쪽 위치
            // 2. 이전 알파벳 가장 오른쪽 위치 -> 가장 오른쪽 위치 -> 가장 왼쪽 위치
            dp[i][0] = minOf(dp[i - 1][0] + (r - prevL).absoluteValue, dp[i - 1][1] + (r - prevR).absoluteValue) + dist
            dp[i][1] = minOf(dp[i - 1][0] + (l - prevL).absoluteValue, dp[i - 1][1] + (l - prevR).absoluteValue) + dist
        }

        print(dp.last().minOf { it } + S.length)
    }
}

fun main() {
    `1796`().solution()
}