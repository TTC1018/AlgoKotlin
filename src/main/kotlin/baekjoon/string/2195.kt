package baekjoon.string

class `2195` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val S = readLine()
        val P = readLine()

        var answer = 0
        var ptr = 0
        while (ptr < P.length) {
            var maxStep = 0
            var step = 0
            for (j in S.indices) {
                if (ptr+step == P.length) {
                    break
                }

                if (P[ptr+step] != S[j]) {
                    maxStep = maxOf(maxStep, step)
                    step = 0
                } else {
                    step++
                }
            }
            ptr += maxOf(maxStep, step)
            answer++
        }
        print(answer)
    }
}