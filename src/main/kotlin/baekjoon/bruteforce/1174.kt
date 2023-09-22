package baekjoon.bruteforce

class `1174` {
    private val nums = mutableListOf<Int>()
    private val answer = mutableListOf<Long>()

    private fun bruteforce() {
        if (nums.isNotEmpty())
            answer.add(nums.joinToString("").toLong())

        for (num in 0..9) {
            nums.lastOrNull()?.run {
                if (num < this) {
                    nums.add(num)
                    bruteforce()
                    nums.removeLast()
                }
            } ?: run {
                nums.add(num)
                bruteforce()
                nums.removeLast()
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()

        bruteforce()
        answer.sort()

        if (answer.size >= N) {
            print(answer[N - 1])
        } else {
            print(-1)
        }
    }
}

fun main() {
    `1174`().solution()
}