package baekjoon.bruteforce

import kotlin.system.exitProcess

class `24268` {

    private var N = 0
    private var d = 0
    private lateinit var converted: String
    private lateinit var digits: IntArray
    private lateinit var used: BooleanArray

    private val sb = StringBuilder()
    private fun bruteforce(cnt: Int) {
        if (cnt == d) {
            val cand = sb.toString().toInt(d)
            if (N < cand) {
                print(cand)
                exitProcess(0)
            }
            return
        }

        val sIdx = if (cnt == 0) 1 else 0
        for (i in sIdx until d) {
            if (used[i].not()) {
                used[i] = true
                sb.append(i)
                bruteforce(cnt + 1)
                sb.deleteAt(sb.length - 1)
                used[i] = false
            }
        }
    }

    private fun convertBaseD(num: Int, base: Int): String {
        val sb = StringBuilder()
        var n = num
        while (n > 0) {
            sb.append(n % base)
            n /= base
        }

        return sb.reverse().toString()
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map { it.toInt() }
            .also { N = it.first(); d = it.last() }

        digits = IntArray(d) { it }
        used = BooleanArray(d) { false }
        converted = convertBaseD(N, d)
        bruteforce(0)
        print(-1)
    }

}

fun main() {

    `24268`().solution()

}