package baekjoon.bruteforce

class `17255` {
    private lateinit var N: String
    private var cnt = 0
    private var answer = 0
    private val checked = mutableSetOf<String>()

    private fun bruteforce(l: Int, r: Int, order: String) {
        if (cnt == N.length) {
            if (order !in checked) {
                checked.add(order)
                answer++
            }
            return
        }
        if (l < 0 || r == N.length) {
            return
        }

        if (l > 0) {
            cnt++
            bruteforce(l - 1, r, order + N[l - 1] + order)
            cnt--
        }
        if (r < N.length - 1) {
            cnt++
            bruteforce(l, r + 1, order + order + N[r + 1])
            cnt--
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine()
        for (i in N.indices) {
            cnt++
            bruteforce(i, i, "${N[i]}")
            cnt--
        }
        print(answer)
    }
}