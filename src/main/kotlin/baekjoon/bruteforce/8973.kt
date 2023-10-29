package baekjoon.bruteforce

class `8973` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val a1 = readLine().split(" ").map(String::toLong)
        val a2 = readLine().split(" ").map(String::toLong)

        var (al, ar) = 0 to 0
        var answer = Long.MIN_VALUE
        var (l, r) = 0 to 0
        while (l < N && r < N) {
            var (L, R) = l to r
            // L, R 포인터가 각각 좌우로 퍼져나가면서 값 다 계산
            // 한줄짜리는 미리 중복값 빼놓기
            var sumVal = if (L == R) -a1[L]*a2[R] else 0
            while (L >= 0 && R < N) {
                sumVal += (a1[L]*a2[R] + a1[R]*a2[L])

                // 최댓값 갱신
                if (sumVal > answer) {
                    answer = sumVal
                    al = L
                    ar = N-1-R
                }

                L--; R++
            }

            if (l != r)
                l++
            else
                r++
        }
        print("$al $ar\n$answer")
    }
}