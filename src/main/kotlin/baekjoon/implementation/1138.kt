package baekjoon.implementation

class `1138` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val H = readLine().split(" ").map(String::toInt)
        val answer = IntArray(N) { -1 }
        for (i in H.indices) {
            var prevCnt = 0
            for (j in 0 until N) {
                if (answer[j] == -1) {
                    if (prevCnt == H[i]) {
                        answer[j] = i+1
                        break
                    }
                    prevCnt++
                }
            }
        }
        print(answer.joinToString(" "))
    }
}