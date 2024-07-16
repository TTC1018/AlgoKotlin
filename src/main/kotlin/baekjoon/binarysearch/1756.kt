package baekjoon.binarysearch

class `1756` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (D, N) = readLine().split(" ").map(String::toInt)
        val P = readLine().split(" ").map(String::toInt)
        val I = readLine().split(" ").map(String::toInt)
        // 최악의 경우 -> 도우가 피자 반죽과 동일할 때
        // 그때는 N^2로 해결 불가능

        // 특정 인덱스까지 들어갈 수 있는 지름 기록
        val prefix = P.toIntArray().apply {
            for (i in 1 until size) {
                this[i] = minOf(this[i], this[i - 1])
            }
        }.reversed()

        // 도우마다 들어갈 수 있는 위치 이분탐색으로 찾기
        var start = 0
        for (ip in I) {
            var (l, r) = start to prefix.lastIndex
            var point = -1
            while (l <= r) {
                val m = (l + r).div(2)

                if (prefix[m] >= ip) {
                    r = m - 1
                    point = m
                } else {
                    l = m + 1
                }
            }

            if (ip <= prefix.getOrElse(point) { Int.MIN_VALUE }) {
                start = point + 1
            } else { // 하나라도 못 들어가면 끝
                print(0)
                return
            }
        }

        // 마지막 까지 기록된 start = 마지막으로 피자 도우가 들어간 한칸 위 자리
        print(prefix.size - (start - 1))
    }
}