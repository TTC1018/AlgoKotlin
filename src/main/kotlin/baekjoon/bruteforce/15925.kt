package baekjoon.bruteforce

class `15925` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, T) = readLine().split(" ").map(String::toInt)
        val B = Array(N) { readLine().split(" ").map(String::toInt).toIntArray() }

        val half = N.div(2)+1
        while (true) {
            var continueFlag = false
            for (i in 0 until N) {
                if (B[i].count { it == T } in half until N) {
                    B[i] = IntArray(N) { T }
                    continueFlag = true
                }
            }
            for (j in 0 until N) {
                if (B.count { it[j] == T } in half until N) {
                    continueFlag = true
                    for (i in 0 until N)
                        B[i][j] = T
                }
            }

            if (continueFlag.not()) {
                for (i in 0 until N) {
                    for (j in 0 until N) {
                        if (B[i][j] != T) {
                            print(0)
                            return
                        }
                    }
                }
                print(1)
                return
            }
        }
    }
}