package baekjoon.bruteforce

import kotlin.system.exitProcess

class `27967` {
    private var n = 0
    private var gIdx = mutableListOf<Int>()
    private lateinit var gCands: CharArray
    private lateinit var S: String

    private fun check(): Boolean {
        val open = mutableListOf<Char>()
        for (i in S.indices) {
            when (gCands[i]) {
                '(' -> open.add('(')
                ')' -> {
                    if (open.isEmpty())
                        return false
                    open.removeLast()
                }
            }
        }

        return open.isEmpty()
    }

    private fun bruteforce(now: Int) {
        if (now == gIdx.size) {
            if (check()) {
                print(S.mapIndexed { i, v ->
                    when (v) {
                        'G' -> gCands[i]
                        else -> v
                    }
                }.joinToString(""))
                exitProcess(0)
            }
            return
        }

        gCands[gIdx[now]] = '('
        bruteforce(now + 1)

        gCands[gIdx[now]] = ')'
        bruteforce(now + 1)
    }

    fun main() = with(System.`in`.bufferedReader()) {
        n = readLine().toInt()
        S = readLine()
        S.forEachIndexed { i, c -> if (c == 'G') gIdx.add(i) }
        gCands = S.toCharArray()

        bruteforce(0)
    }
}