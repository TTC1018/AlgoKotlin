package baekjoon.string

import kotlin.system.exitProcess

class `23304` {
    private fun isAka(s: String) {
        if (s.length == 1)
            return

        var (l, r) = 0 to s.length - 1
        while (l < r) {
            if (s[l++] != s[r--]) {
                print("IPSELENTI")
                exitProcess(0)
            }
        }

        isAka(s.slice(0 until s.length / 2))
    }

    fun main() = with(System.`in`.bufferedReader()) {
        isAka(readLine())
        print("AKARAKA")
    }
}