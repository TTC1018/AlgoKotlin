package baekjoon.bruteforce

class `2922` {
    private lateinit var S: String
    private var answer = 0L
    private val V = buildSet { addAll("AEIOU".toList()) }
    private var lCounter = 0

    fun bruteforce(idx: Int, v: Int, c: Int, cnt: Long) {
        if (v == 3 || c == 3)
            return

        if (idx == S.length) {
            if (lCounter > 0) {
                answer += cnt
            }
            return
        }

        if (S[idx] == '_') {
            bruteforce(idx + 1, v + 1, 0, cnt * 5)
            bruteforce(idx + 1, 0, c + 1, cnt * 20)
            lCounter++
            bruteforce(idx + 1, 0, c + 1, cnt)
            lCounter--
        } else {
            if (S[idx] in V) { // 모음
                bruteforce(idx + 1, v + 1, 0, cnt)
            } else { // 자음
                if (S[idx] == 'L')
                    lCounter++
                bruteforce(idx + 1, 0, c + 1, cnt)
                if (S[idx] == 'L')
                    lCounter--
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        S = readLine()
        if (S.first() == 'L')
            lCounter++
        bruteforce(0, 0, 0, 1)
        print(answer)
    }
}