package baekjoon.implementation

class `1972` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        val ss = mutableMapOf<Int, MutableSet<String>>()
        loop@while (true) {
            val S = readLine()
            if (S == "*")
                break
            for (i in S.indices) {
                for (j in i + 1 until S.length) {
                    val cand = "${S[i]}${S[j]}"
                    if (cand in ss.getOrPut(j - i) { mutableSetOf() }) {
                        ss.clear()
                        sb.appendLine("$S is NOT surprising.")
                        continue@loop
                    }
                    ss[j - i]!!.add(cand)
                }
            }
            ss.clear()
            sb.appendLine("$S is surprising.")
        }
        print(sb.dropLast(1))
    }
}