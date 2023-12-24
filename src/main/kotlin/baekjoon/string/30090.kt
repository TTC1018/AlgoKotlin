package baekjoon.string

class `30090` {
    private var N = 0
    private lateinit var S: List<String>
    private var bit = 0
    private val cand = StringBuilder()
    private var temp = 0
    private var answer = Int.MAX_VALUE

    private fun Int.toBit() = (1 shl this)

    private fun match(a: String): Int {
        if (cand.isEmpty())
            return 0

        val end = minOf(cand.length, a.length)
        for (ptr in end downTo 1) {
            if (cand.substring(cand.length - ptr) == a.substring(0 until ptr))
                return ptr
        }
        return -1
    }

    private fun bruteforce(cnt: Int) {
        if (cnt == N) {
            answer = minOf(answer, temp)
            return
        }

        for (i in 0 until N) {
            if (bit and i.toBit() == 0) {
                val matched = match(S[i])
                val added = S[i].length - matched
                if (matched > -1) {
                    cand.append(S[i].substring(matched))
                    bit = bit or i.toBit()
                    temp += added
                    bruteforce(cnt + 1)
                    temp -= added
                    bit = bit xor i.toBit()
                    cand.deleteRange(cand.length - added, cand.length)
                }
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        S = List(N) { readLine() }
        bruteforce(0)
        print(answer)
    }
}