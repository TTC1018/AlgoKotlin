package baekjoon.math

class `18291` {
    private val MOD = 1e9.toInt() + 7

    private fun expo(n: Int): Long {
        if (n <= 0) {
            return 1
        }

        val prev = expo(n / 2).let { it * it % MOD }
        return if (n and 1 == 0) {
            prev
        } else {
            2 * prev % MOD
        }
    }

    fun main() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            sb.appendLine(expo(readLine().toInt() - 2))
        }
        print(sb.dropLast(1))
    }
}