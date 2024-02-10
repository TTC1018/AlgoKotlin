package baekjoon.greedy

class `20310` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val S = readLine()
        var oneLeft = S.count { it == '1' }.div(2)
        var zeroLeft = S.count { it == '0' }.div(2)
        val erased = BooleanArray(S.length) { false }
        for (i in S.indices) {
            if (S[i] == '1') {
                oneLeft--
                erased[i] = true
                if (oneLeft == 0)
                    break
            }
        }
        for (i in S.indices.reversed()) {
            if (S[i] == '0') {
                zeroLeft--
                erased[i] = true
                if (zeroLeft == 0)
                    break
            }
        }
        print(S.filterIndexed { i, c -> erased[i].not() })
    }
}