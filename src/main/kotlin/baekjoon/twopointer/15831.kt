package baekjoon.twopointer

class `15831` {
    private fun Map<Char, Int>.dGet(key: Char) = getOrDefault(key, 0)

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, B, W) = readLine().split(" ").map(String::toInt)
        val S = readLine()
        var answer = 0
        var (l, r) = 0 to 0
        val counter = mutableMapOf<Char, Int>()
        while (r < N) {
            if (counter.dGet('B') > B) {
                counter[S[l]] = counter.dGet(S[l++]) - 1
            } else {
                counter[S[r]] = counter.dGet(S[r++]) + 1
            }

            if (counter.run { dGet('B') <= B && dGet('W') >= W }) {
                answer = answer.coerceAtLeast(r - l)
            }
        }
        print(answer)
    }
}