package baekjoon.geometry

class `1027` {

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val B = readLine().split(" ").map(String::toInt).toIntArray()

        var answer = 0
        for (i in B.indices) {
            var tempAnswer = 0
            var leftSlope = 0.0
            for (j in i-1 downTo 0) {
                val slope = (B[i] - B[j]) / (i - j).toDouble()

                if (j == i - 1 || slope < leftSlope) {
                    leftSlope = slope
                    tempAnswer++
                }
            }

            var rightSlope = 0.0
            for (j in i+1 until N) {
                val slope = (B[i] - B[j]) / (i - j).toDouble()

                if (j == i + 1 || slope > rightSlope) {
                    rightSlope = slope
                    tempAnswer++
                }
            }
            answer = maxOf(answer, tempAnswer)
        }

        print(answer)
    }
}

fun main() {
    `1027`().solution()
}