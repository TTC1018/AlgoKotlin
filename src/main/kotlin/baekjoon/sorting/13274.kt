package baekjoon.sorting

import java.util.*

class `13274` {
    fun solution() = with(System.`in`.bufferedReader()) {
        var (N, K) = readLine().split(" ").map(String::toInt)
        var st = StringTokenizer(readLine())
        val nums = LongArray(N) { st.nextToken().toLong() }.sortedArray()
        val next = LongArray(N)

        while (K-- > 0) {
            var nPtr = 0
            st = StringTokenizer(readLine())
            val L = st.nextToken().toInt() - 1
            val R = st.nextToken().toInt() - 1
            val X = st.nextToken().toInt()

            var ptr = L
            for (i in 0 until L) {
                while (ptr <= R && nums[ptr] + X <= nums[i]) {
                    next[nPtr++] = nums[ptr++] + X
                }
                next[nPtr++] = nums[i]
            }
            for (i in R + 1 until N) {
                while (ptr <= R && nums[ptr] + X <= nums[i]) {
                    next[nPtr++] = nums[ptr++] + X
                }
                next[nPtr++] = nums[i]
            }

            while (ptr <= R) {
                next[nPtr++] = nums[ptr++] + X
            }

            for (i in 0 until N) {
                nums[i] = next[i]
            }
        }

        System.out.bufferedWriter()
            .use {
                for (num in nums) {
                    it.write("$num ")
                }
                it.flush()
            }
    }
}