package baekjoon.implementation



class `1148` {

    private fun Char.toIdx() = this - 'A'
    private fun Int.toAlpha() = 'A' + this
    private fun satisfied(a: IntArray, b: IntArray): Boolean {
        for (i in 0..'Z'.toIdx()) {
            if (a[i] < b[i])
                return false
        }
        return true
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        val W = mutableListOf<IntArray>().apply {
            while (true) {
                val word = readLine()
                if (word == "-")
                    break
                add(IntArray('Z'.toIdx() + 1).apply {
                    for (w in word) this[w.toIdx()]++ }
                )
            }
        }

        val sb = StringBuilder()
        while (true) {
            val P = readLine()
            if (P == "#")
                break

            val pCounter = IntArray('Z'.toIdx() + 1).apply {
                for (p in P) this[p.toIdx()]++
            }
            val answer = IntArray('Z'.toIdx() + 1)
            for (word in W) {
                if (satisfied(pCounter, word).not())
                    continue

                for (i in 0..'Z'.toIdx())
                    if (word[i] > 0)
                        answer[i]++
            }

            var minVal = Int.MAX_VALUE
            var maxVal = Int.MIN_VALUE
            for (i in 0..'Z'.toIdx()) {
                if (pCounter[i] > 0) {
                    minVal = minOf(minVal, answer[i])
                    maxVal = maxOf(maxVal, answer[i])
                }
            }

            for (i in 0..'Z'.toIdx()) {
                if (answer[i] == minVal && pCounter[i] > 0)
                    sb.append(i.toAlpha())
            }
            sb.append(" $minVal ")
            for (i in 0..'Z'.toIdx()) {
                if (answer[i] == maxVal && pCounter[i] > 0)
                    sb.append(i.toAlpha())
            }
            sb.append(" $maxVal\n")
        }
        print(sb)
    }
}

fun main() {
    `1148`().solution()
}