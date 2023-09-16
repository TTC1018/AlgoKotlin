package baekjoon.greedy

class `24023` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val A = readLine().split(" ").map(String::toInt)

        var mask = 0
        var s = 0
        for (i in 0 until N) {
            if (K or A[i] > K) {
                mask = 0
                s = i + 1
            } else {
                mask = mask or A[i]
                if (mask == K) {
                    print("${s+1} ${i+1}")
                    return
                }
            }
        }

        print(-1)
    }
}

fun main() {
    `24023`().solution()
}