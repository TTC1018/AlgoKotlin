package baekjoon.binarysearch

class `2110` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, C) = readLine().split(" ").map { it.toInt() }
        val H = Array(N) { readLine().toInt() }.sorted()

        var left = 1
        var right = H.last()
        while (left <= right){
            val mid = (left + right).div(2)
            var prev = H.first()
            var cnt = 1
            for (i in 1 until N){
                if (prev + mid <= H[i]){
                    cnt++
                    prev = H[i]
                }
            }

            if (cnt >= C)
                left = mid + 1
            else
                right = mid - 1
        }
        print(left - 1)
    }

}

fun main() {

    `2110`().solution()

}