package baekjoon.math

class `6884` {
    private fun isPrime(now: Int): Boolean {
        if (now <= 1)
            return false

        for (n in 2..kotlin.math.sqrt(now.toFloat()).toInt()) {
            if (now % n == 0)
                return false
        }
        return true
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        var t = readLine().toInt()
        loop@ while (t-- > 0) {
            val nums = readLine().split(" ").drop(1).map(String::toInt)
            val prefix = IntArray(nums.size).apply {
                this[0] = nums.first()
                for (i in 1 until size) {
                    this[i] += this[i - 1] + nums[i]
                }
            }
            for (l in 2..nums.size) {
                for (i in l - 1 until nums.size) {
                    if (isPrime(prefix[i] - prefix.getOrElse(i - l) { 0 })) {
                        sb.appendLine(
                            "Shortest primed subsequence is length $l: ${
                                nums.subList(i - l + 1, i + 1).joinToString(" ")
                            }"
                        )
                        continue@loop
                    }
                }
            }
            sb.appendLine("This sequence is anti-primed.")
        }
        print(sb.dropLast(1))
    }
}