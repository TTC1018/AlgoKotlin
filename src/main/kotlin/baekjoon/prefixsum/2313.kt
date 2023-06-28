package baekjoon.prefixsum

class `2313` {

    fun solution() = with(System.`in`.bufferedReader()) {
        var sumVal = 0L
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            val L = readLine().toInt()
            val J = readLine().split(" ").map(String::toLong).toLongArray()
            var maxVal = J.first()
            var (maxLeft, maxRight) = listOf(0, 0)
            var (left, right) = listOf(0, 0)

            for (i in 1 until L) {
                if (J[i] >= J[i - 1] + J[i])
                    left = i
                else
                    J[i] += J[i - 1]
                right = i

                if (maxVal < J[i]) {
                    maxVal = J[i]
                    maxLeft = left; maxRight = right
                } else if (maxVal == J[i] && (right - left) < (maxRight - maxLeft)) {
                    maxLeft = left; maxRight = right
                }
            }

            sumVal += maxVal
            sb.append("${maxLeft + 1} ${maxRight + 1}\n")
        }
        println(sumVal)
        print(sb.deleteAt(sb.length - 1))
    }

}

fun main() {
    `2313`().solution()
}