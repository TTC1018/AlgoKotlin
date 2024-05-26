package baekjoon.bruteforce

class `9742` {
    private fun perm() {
        if (cands.size == S.length) {
            if (++cnt == p) {
                sb.appendLine("$S $p = ${cands.joinToString("")}")
            }
            return
        }

        for (i in S.indices) {
            if (V[i].not()) {
                V[i] = true
                cands.add(S[i])
                perm()
                cands.removeLast()
                V[i] = false
            }
        }
    }

    private val sb = StringBuilder()
    private lateinit var S: String
    private lateinit var V: BooleanArray
    private var p = 0
    private var cnt = 0
    private val cands = mutableListOf<Char>()

    fun solution() = with(System.`in`.bufferedReader()) {
        while (true) {
            val prevLength = sb.length
            cands.clear()
            cnt = 0
            try {
                readLine().split(" ").run {
                    S = first(); p = last().toInt()
                }
                V = BooleanArray(p) { false }
                perm()

                if (prevLength == sb.length) {
                    sb.appendLine("$S $p = No permutation")
                }
            } catch (e: Exception) {
                break
            }
        }
        print(sb.dropLast(1))
    }
}