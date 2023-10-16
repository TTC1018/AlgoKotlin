package baekjoon.greedy

import kotlin.math.absoluteValue

class `26075` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val (S, T) = readLine() to readLine()
        var (p1, p2) = 0 to 0

        var (X, Y) = 0L to 0L
        var cntLeft = M
        while (cntLeft > 0) {
            when {
                // 어차피 옮겨야 하는 것은 1
                // 서로 그나마 가장 가까운 1끼리 이동시켜야 됨
                // 가장 가까운 1 간의 거리의 반을 서로 이동하고,
                // 만약 거리가 홀수라서 한 쪽이 1만큼 더 이동해야 된다면
                // X와 Y중 더 작은 값을 갖는 문자열이 한번 더 이동한다.
                S[p1] == '1' && T[p2] == '1' -> {
                    val dist = (p1 - p2).absoluteValue
                    val half = dist.div(2)
                    X += half
                    Y += half
                    if (dist % 2 != 0) {
                        if (X >= Y)
                            Y++
                        else
                            X++
                    }
                    p1++
                    p2++
                    cntLeft--
                }

                else -> {
                    if (S[p1] != '1')
                        p1++
                    if (T[p2] != '1')
                        p2++
                }
            }
        }
        print(X * X + Y * Y)
    }
}