package baekjoon.divideandconquer

import kotlin.math.pow

class `4779` {
    private var N = 0
    private lateinit var S: CharArray

    private fun dAndC(s: Int, e: Int) {
        if (s == e)
            return

        val l = (e-s+1).div(3)
        for (i in s+l..e-l)
            S[i] = ' '
        dAndC(s, s+l-1)
        dAndC(e-l+1, e)
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        while (true) {
            try {
                N = readLine().toInt()
                S = "-".repeat((3.0).pow(N).toInt()).toCharArray()
                dAndC(0, S.size-1)
                println(S.joinToString(""))
            } catch (e: Exception) {
                break
            }
        }
    }
}