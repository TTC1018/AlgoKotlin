package baekjoon.adhoc

class `21605` {
    fun solution() = with(System.`in`.bufferedReader()) {
        // B0 = 0
        // B1 = B0 * A1 + A2 -> 1
        // B2 = B1 * A3 + A4 ->
        // .. 마지막 BN이 최대가 되려면
        // B1 -> -1 1 = 1
        // B2 -> 1 -1 -1 1 = 2
        // B3 -> 1 -1 1 -1 -1 1 = 3
        // B4 -> 1 -1 1 -1 1 -1 -1 1 = 4
        // BN -> (1 -1) * (N-1) + (-1 1)
        val N = readLine().toInt()
        print("1 -1 ".repeat(N-1) + "-1 1")
    }
}