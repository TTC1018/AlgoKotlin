package baekjoon.binarysearch

class `7795` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            val (N, M) = readLine().split(" ").map(String::toInt)
            val A = readLine().split(" ").map(String::toInt).sorted()
            val B = readLine().split(" ").map(String::toInt).sorted()
            var answer = 0
            for (a in A) {
                var (l, r) = 0 to M - 1
                var target = -1
                while (l <= r) {
                    val m = (l + r).div(2)

                    if (B[m] <= a) {
                        l = m + 1
                        target = m
                    } else {
                        r = m - 1
                    }
                }

                while (target >= 0 && B[target] == a) {
                    target--
                }
                answer += target + 1
            }
            sb.appendLine(answer)
        }
        print(sb.dropLast(1))
    }
}