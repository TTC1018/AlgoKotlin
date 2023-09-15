package baekjoon.binarysearch

class `18114` {
    private var N = 0
    private var C = 0
    private lateinit var W: List<Int>

    private fun binarySearch(left: Int, right: Int, target: Int): Boolean {
        var (l, r) = left to right

        while (l <= r) {
            val mid = (l + r).div(2)

            when {
                W[mid] == target -> return true
                W[mid] > target -> r = mid - 1
                W[mid] < target -> l = mid + 1
            }
        }
        return false
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run { N = first(); C = last() }
        W = readLine().split(" ").map(String::toInt).sorted()

        if (binarySearch(0, N - 1, C)) {
            print(1)
        } else {
            for (i in 0 until N) {
                if (W[i] > C)
                    break

                for (j in i + 1 until N) {
                    val sumVal = W[i] + W[j]
                    if (sumVal > C)
                        break

                    if (sumVal == C) {
                        print(1)
                        return
                    }

                    if (binarySearch(j + 1, N - 1, C - sumVal)) {
                        print(1)
                        return
                    }
                }
            }
            print(0)
        }
    }
}

fun main() { `18114`().solution() }