package baekjoon.math

class `1364` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toLong()
        // 6 => 7
        // 7 => 8, 1증가
        // 8 => 10, 2증가
        // 9 => 12
        // 10 => 14
        // 11 => 16
        // 12 => 19
        // 13 => 21, 2증가
        // 14 => 24, 3증가
        // 15 => 27
        if (N < 6) {
            print(N)
        } else {
            var answer = 0L
            val level = N / 6
            val mod = N % 6

            answer += (3 * level * (level + 1) + 1)
            if (mod > 0)
                answer += ((level + 1) * mod - 1)
            print(answer)
        }
    }
}