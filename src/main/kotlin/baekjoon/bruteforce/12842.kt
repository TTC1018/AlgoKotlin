package baekjoon.bruteforce

class `12842` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (n, s) = readLine().split(" ").map(String::toInt)
        val m = readLine().toInt()
        val B = List(m) { readLine().toInt() }
        // 먹은 개수 = n-s
        // 지금 남은 초 내에 있는 애들은 다 먹음
        // 계속 줄이다가 넘어설 때 끝내기
        var left = n - s
        var t = 0
        while (left > 0) {
            for (i in B.indices) {
                if (t % B[i] == 0) {
                    left--

                    if (left == 0) {
                        print(i+1)
                        return
                    }
                }
            }
            t++
        }
    }
}