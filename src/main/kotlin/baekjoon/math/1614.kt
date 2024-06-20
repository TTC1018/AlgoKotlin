package baekjoon.math

class `1614` {
    fun main() = with(System.`in`.bufferedReader()) {
        val F = readLine().toInt()
        val N = readLine().toLong()
        // 1은 8로 나눈 수
        // 5는 베이스4 8로 나눈 수
        // 2는 베이스1 홀수번째가 6개, 짝수번째가 2개 -> 홀수개면 (n-1)*8 + 6, 짝수개면 n*8
        // 3은 베이스2 홀수번째가 4개, 짝수번째가 4개
        // 4는 베이스3 홀수번째가 2개, 짝수번째가 6개
        print(
            when (F) {
                1 -> N * 8
                2 -> 1 + N.run { if (N and 1L == 1L) floorDiv(2) * 8 + 6 else floorDiv(2) * 8 }
                3 -> 2 + N.run { if (N and 1L == 1L) floorDiv(2) * 8 + 4 else floorDiv(2) * 8 }
                4 -> 3 + N.run { if (N and 1L == 1L) floorDiv(2) * 8 + 2 else floorDiv(2) * 8 }
                else -> 4 + N * 8
            }
        )
    }
}