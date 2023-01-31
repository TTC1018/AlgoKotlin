package baekjoon.twopointer

class `1253` {

    private var N = 0
    private lateinit var A: LongArray

    fun solution() = with(System.`in`.bufferedReader()) {

        N = readLine().toInt()
        A = readLine().split(" ").map { it.toLong() }.toLongArray()
        A.sort()

        var answer = 0
        for (i in 0 until N){
            var left = 0
            var right = N - 1

            while (left < right) {
                val sumVal = A[left] + A[right]
                when {
                    sumVal == A[i] -> {
                        when {
                            left == i -> left++
                            right == i -> right--
                            else -> {
                                answer++
                                break
                            }
                        }
                    }
                    sumVal < A[i] -> left++
                    sumVal > A[i] -> right--
                }
            }
        }

        print(answer)
    }

}

fun main() {

    `1253`().solution()

}