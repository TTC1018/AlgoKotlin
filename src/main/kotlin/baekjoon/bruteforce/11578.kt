package baekjoon.bruteforce

class `11578` {
    private var N = 0
    private var M = 0
    private var SOLVED = 0
    private lateinit var P: List<Int>
    private var temp = 0
    private var answer = Int.MAX_VALUE

    private fun bruteforce(now: Int, cnt: Int) {
        if (temp == SOLVED) {
            answer = minOf(answer, cnt)
            return
        }
        if (now == M) {
            return
        }

        bruteforce(now + 1, cnt)

        val prevBit = temp
        temp = temp or P[now]
        bruteforce(now + 1, cnt + 1)
        temp = prevBit
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); M = last()
        }
        SOLVED = (1 shl N) - 1
        P = List(M) { readLine().split(" ").map { it.toInt() - 1 }.drop(1) }
            .map {
                var bit = 0
                for (n in it)
                    bit = bit or (1 shl n)
                bit
            }
        // 문제의 개수 = 10
        // 비트마스킹 가능할듯?
        // 학생 수도 10 이하 -> 브루트포스
        bruteforce(0, 0)
        if (answer == Int.MAX_VALUE)
            print(-1)
        else
            print(answer)
    }
}