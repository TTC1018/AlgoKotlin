package baekjoon.bruteforce

class `1711` {
    private data class Loc(
        val x: Long,
        val y: Long,
    ) {
        operator fun plus(other: Loc) = (x - other.x) * (x - other.x) + (y - other.y) * (y - other.y)
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        // 직각 삼각형 찾기 -> 수평에 같은 점 두개? 아닌 경우도 있다
        // N^3으로는 못 품
        // 1500C3 -> 대략 5.6억 -> 5초 가능?
        val N = readLine().toInt()
        val L = List(N) { readLine().split(" ").map(String::toLong).run { Loc(first(), last()) } }
        var answer = 0
        for (i in 0 until N) {
            for (j in i + 1 until N) {
                for (k in j + 1 until N) {
                    val a = L[i] + L[j]
                    val b = L[i] + L[k]
                    val c = L[j] + L[k]

                    val biggest = maxOf(a, b, c)
                    val sumVal = a + b + c
                    if (sumVal / 2 == biggest) {
                        answer++
                    }
                }
            }
        }
        print(answer)
    }
}