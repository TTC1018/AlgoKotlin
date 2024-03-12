package baekjoon.sorting

import kotlin.system.exitProcess

class `24060` {
    private var N = 0
    private var K = 0
    private lateinit var A: IntArray
    private var answer = 0

    private fun mergeSort(s: Int, e: Int) {
        if (s < e) {
            val m = (s + e).div(2)
            mergeSort(s, m)
            mergeSort(m + 1, e)

            var i = s
            var j = m + 1
            var t = 1
            val temp = IntArray(e - s + 2)
            while (i <= m && j <= e) {
                if (A[i] <= A[j]) {
                    temp[t++] = A[i++]
                } else {
                    temp[t++] = A[j++]
                }
            }

            while (i <= m) {
                temp[t++] = A[i++]
            }
            while (j <= e) {
                temp[t++] = A[j++]
            }

            i = s
            t = 1
            while (i <= e) {
                A[i++] = temp[t++]
                answer++

                if (answer == K) {
                    print(A[i - 1])
                    exitProcess(0)
                }
            }
        }
    }


    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); K = last()
        }
        A = readLine().split(" ").map(String::toInt).toIntArray()
        mergeSort(0, N - 1)
        print(-1)
    }
}