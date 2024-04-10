package baekjoon.bruteforce

class `3671` {
    private fun bruteforce() {
        if (nums.size >= 1) {
            val num = nums.joinToString("").toInt()
            if (P[num]) {
                cands.add(num)
            }
        }

        for (i in S.indices) {
            if (V[i].not()) {
                V[i] = true
                nums.add(S[i])
                bruteforce()
                nums.removeLast()
                V[i] = false
            }
        }
    }

    private val P = BooleanArray(10000000) { true }.apply {
        this[0] = false
        this[1] = false
        for (n in 2..kotlin.math.sqrt(10000000.0).toInt()) {
            for (i in 2..9999999.div(n)) {
                this[n * i] = false
            }
        }
    }
    private lateinit var S: List<Int>
    private lateinit var V: BooleanArray
    private val nums = mutableListOf<Int>()
    private val cands = mutableSetOf<Int>()

    fun solution() = with(System.`in`.bufferedReader()) {
        // 많아야 7개 -> 7자리 이하의 소수
        // 체 만들어 두고 브루트포스
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            S = readLine().map(Char::digitToInt)
            V = BooleanArray(S.size) { false }
            cands.clear()
            bruteforce()
            sb.appendLine(cands.size)
        }
        print(sb.dropLast(1))
    }
}