package baekjoon.slidingwindow

class `1522` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val s = readLine()
        val S = s.repeat(2) // 원형이므로 한번 더 연장해서 판단
        val aCnt = s.count { it == 'a' }
        val P = IntArray(S.length + 1).apply {
            for (i in 1..S.length) {
                this[i] += this[i-1]
                if (S[i-1] == 'b') {
                    this[i] += 1
                }
            }
        }

        // 연속된 a의 길이는 a의 개수일 것이다.
        // 즉, a의 길이 만큼의 문자열을 탐색해나가며
        // 그 안의 b를 외부 a와 교체하면 된다
        var answer = s.length
        for (start in 0 until S.length - aCnt) {
            answer = minOf(answer, P[start + aCnt] - P[start])
        }
        print(answer)
    }
}