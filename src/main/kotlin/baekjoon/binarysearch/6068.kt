package baekjoon.binarysearch

class `6068` {
    private data class Job(
        val t: Int,
        val s: Int,
    )


    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val J = List(N) { readLine().split(" ").map(String::toInt).run { Job(first(), last()) } }
            .sortedBy { it.s }
        // 끝내야 하는 시간 - 필요한 시간 = 무조건 시작해야 되는 시간
        var answer = -1
        var (left, right) = 1 to 1000000
        while (left <= right) {
            val mid = (left + right).div(2)

            var S = mid
            var cnt = 0
            for ((t, s) in J) {
                S += t
                if (S > s)
                    break
                cnt++
            }

            if (cnt == N) {
                left = mid + 1
                answer = mid
            } else {
                right = mid - 1
            }
        }
        print(answer)
    }
}