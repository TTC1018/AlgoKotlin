package baekjoon.bruteforce

class `25602` {
    private var N = 0
    private var K = 0
    private lateinit var A: IntArray
    private lateinit var R: List<List<Int>>
    private lateinit var M: List<List<Int>>
    private var answer = 0

    private fun bruteforce(day: Int, sum: Int) {
        if (day == K) {
            answer = maxOf(answer, sum)
            return
        }

        for (i in A.indices) {
            if (A[i] > 0) {
                A[i]--
                for (j in A.indices) {
                    if (A[j] > 0) {
                        A[j]--
                        bruteforce(day + 1, sum + R[day][i] + M[day][j])
                        A[j]++
                    }
                }
                A[i]++
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); K = last()
        }
        A = readLine().split(" ").map(String::toInt).toIntArray()
        R = List(K) { readLine().split(" ").map(String::toInt) }
        M = List(K) { readLine().split(" ").map(String::toInt) }
        bruteforce(0, 0)
        print(answer)
    }
}