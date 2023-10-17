package baekjoon.bruteforce

class `10881` {
    fun solution() = with(System.`in`.bufferedReader()) {
        repeat(readLine().toInt()) {
            val W = IntArray(6)
            val H = IntArray(6)

            repeat(3) {
                val (w, h) = readLine().split(" ").map(String::toInt)
                W[it] = w; W[it + 3] = h
                H[it] = h; H[it + 3] = w
            }

            var answer = Int.MAX_VALUE
            for (i in 0 until 6) {
                for (j in 0 until 6) {
                    for (k in 0 until 6) {
                        if (i % 3 != j % 3 && j % 3 != k % 3 && i % 3 != k % 3) {
                            var totalW = W[i]+W[j]+W[k]
                            var totalH = maxOf(H[i], H[j], H[k])
                            answer = minOf(answer, totalW*totalH)

                            totalW = maxOf(W[i]+W[j], W[k])
                            totalH = maxOf(H[i], H[j]) + H[k]
                            answer = minOf(answer, totalW * totalH)
                        }
                    }
                }
            }
            println(answer)
        }
    }
}

fun main() {
    `10881`().solution()
}