package baekjoon.math

import kotlin.math.pow

class `1790` {
    private fun Long.base10Pow() = (10.0).pow(this.toInt()).toLong()

    // N자리 수 숫자 개수
    private fun Long.getRange() = (base10Pow() - (this - 1).base10Pow())

    // N자리 수 이어 붙였을 때 길이
    private fun Long.getLengthRange() = this * getRange()

    // 1 ~ 9 1개씩 -> 1 * 9
    // 10 ~ 99 2개씩 -> 2 * 90
    // 100 ~ 999 3개씩 -> 3 * 900
    // ... -> N * (10**N - 10**(N-1))
    // 1. 어느 구역에 있는지 확인
    // 2. 해당 구역 숫자 길이로 나눠서 몇번째 수인지 확인
    // 3. 그 수의 길이로 또 나눠서 숫자의 몇번째 수인지 확인
    fun solution() = with(System.`in`.bufferedReader()) {
        var (N, k) = readLine().split(" ").map(String::toLong)
        val fullLength = run {
            var sumVal = 0L
            var rangeNum = 1L
            while (rangeNum.getRange() <= N) {
                sumVal += rangeNum.getLengthRange()
                N -= rangeNum.getRange()
                rangeNum++
            }

            if (N > 0) {
                sumVal += N * rangeNum
            }
            sumVal
        }

        if (fullLength < k) {
            print(-1)
        } else {
            var rangeNum = 1L
            var sumVal = 0L
            while (sumVal < k) {
                sumVal += rangeNum.getLengthRange()
                rangeNum++
            }

            // 10 -> 0/1 1/0
            // 11 -> 1/1 2/0
            // 나머지가 0이면 끝 숫자
            val rangeLength = rangeNum - 1
            val realRange = k - (sumVal - rangeLength.getLengthRange())
            // 시작 베이스 수
            val base = (rangeLength - 1).base10Pow()
            val mod = realRange.mod(rangeLength)
            // 나머지 1, 2, ..., length-1, 0까지가 목표 범위 내임
            val div = realRange.div(rangeLength).run { if (mod == 0L) this - 1 else this }
            val target = base + div

            if (mod == 0L) {
                print("$target".last())
            } else {
                print("$target"[mod.minus(1).toInt()])
            }
        }
    }
}