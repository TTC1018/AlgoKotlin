package baekjoon.implementation

class `26597` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val Q = readLine().toInt()
        var (minVal, maxVal) = -1e18.toLong() to 1e18.toLong()
        var answerIdx = Int.MAX_VALUE
        repeat(Q) {
            val ops = readLine().split(" ")
            val n = ops.first().toLong()
            val op = ops.last()
            when (op) {
                "^" -> minVal = maxOf(minVal, n+1)
                "v" -> maxVal = minOf(maxVal, n-1)
            }

            if (minVal == maxVal) {
                answerIdx = minOf(it+1, answerIdx)
            } else if (minVal > maxVal) {
                println("Paradox!")
                print(it+1)
                return@with
            }
        }
        if (answerIdx != Int.MAX_VALUE)
            print("I got it!\n$answerIdx")
        else
            print("Hmm...")
    }
}