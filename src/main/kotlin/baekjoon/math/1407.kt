package baekjoon.math

class `1407` {
    private fun calc(x: Long): Long {
        if (x <= 1) {
            return x
        } else {
            // 홀수 -> 무조건 1, n의 절반은 홀수
            var result = 0L
            // f(2)*2 = f(4), f(4)*2 = f(8)... f(x) = 2* f(x / 2)
            result += (x / 2 + 2 * calc(x / 2))
            // n이 홀수라면 자기 자신까지 포함해서 1추가
            if (x and 1L == 1L)
                result++
            return result
        }
    }


    fun solution() = with(System.`in`.bufferedReader()) {
        val (A, B) = readLine().split(" ").map(String::toLong)
        print(calc(B) - calc(A - 1))
    }
}