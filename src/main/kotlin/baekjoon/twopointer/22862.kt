package baekjoon.twopointer

class `22862` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val S = readLine().split(" ").map(String::toInt)
        var left = K
        var (l, r) = 0 to 0
        var temp = 0
        var answer = 0
        while (r < N) {
            if (S[r] and 1 == 0) {
                temp++
                r++
            } else {
                if (left > 0) {
                    left--
                    r++
                } else {
                    answer = maxOf(answer, temp)
                    if (S[l] and 1 == 0) {
                        temp--
                    } else {
                        left++
                    }
                    l++
                }
            }
        }
        print(maxOf(answer, temp))
    }
}