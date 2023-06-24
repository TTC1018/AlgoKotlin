package baekjoon.binarysearch

class `20495` {

    private data class AB(
        val a: Int,
        val b: Int
    ) {
        fun minVal() = a - b
        fun maxVal() = a + b
    }


    private fun binarySearch(s: Int, e: Int, targetVal: Int, lowerBound: Boolean = true): Int {
        var (left, right) = listOf(s, e)
        var result = 0
        while (left <= right) {
            val mid = (left + right).div(2)

            if (lowerBound) {
                if (targetVal <= maxVals[mid]) {
                    right = mid - 1
                    result = mid
                }
                else {
                    left = mid + 1
                }
            }
            else {
                if (targetVal >= minVals[mid]) {
                    left = mid + 1
                    result = mid
                }
                else {
                    right = mid - 1
                }
            }
        }

        return result
    }

    private lateinit var abs: Array<AB>
    private lateinit var minVals: IntArray
    private lateinit var maxVals: IntArray
    private lateinit var a1: IntArray
    private lateinit var a2: IntArray

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        abs = Array(N) { readLine().split(" ").map(String::toInt).let { AB(it[0], it[1]) } }

        a1 = IntArray(N)
        a2 = IntArray(N)
        minVals = abs.sortedBy { it.minVal() }.map(AB::minVal).toIntArray()
        maxVals = abs.sortedBy { it.maxVal() }.map(AB::maxVal).toIntArray()

        for (i in 0 until N) {
            val minVal = abs[i].minVal()
            val maxVal = abs[i].maxVal()

            val left = binarySearch(0, N-1, minVal)
            val right = binarySearch(0, N-1, maxVal, false)
            a1[i] = left
            a2[i] = right
        }
        print(a1.zip(a2).joinToString("\n") { "${it.first+1} ${it.second+1}" })
    }

}

fun main() {

    `20495`().solution()

}