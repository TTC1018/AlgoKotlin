package baekjoon.bruteforce

class `15931` {
    private var n = 0
    private var left = 52
    private val C = IntArray(4 + 1)
    private var nums = 13
    private var minVal = Int.MAX_VALUE

    private fun count(): Int {
        var tempCnt = 0
        while (true) {
            // 3부터 소거
            when {
                C[3] > 0 -> C[3]--
                C[4] > 0 -> C[4]--
                else -> break
            }
            // 2-4-3 순으로 2로 소거
            when {
                C[2] > 0 -> C[2]--
                C[4] > 0 -> { C[4]--; C[2]++ }
                C[3] > 0 -> C[3]--
                else -> break
            }
            tempCnt++
        }
        return tempCnt
    }

    private fun bruteforce(idx: Int) {
        if (idx == C.size) {
            if (left == 0 && nums == 0) {
                minVal = minOf(minVal, count())
            }
            return
        }

        val end = nums
        for (num in 0..end) {
            if (num * idx <= left) {
                // num개의 숫자들에 각각 idx개만큼 카드 할당
                C[idx] = num
                nums -= num
                left -= num * idx
                bruteforce(idx + 1)
                left += num * idx
                nums += num
                C[idx] = 0
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        n = readLine().toInt()
        left -= n
        bruteforce(0)
        val maxVal = left.coerceAtMost(40).div(5)
        print("$minVal $maxVal")
    }
}