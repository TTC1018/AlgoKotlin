package baekjoon.bruteforce

class `2190` {
    private data class Point(
        val x: Int,
        val y: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, A, B) = readLine().split(" ").map(String::toInt)
        // 테두리상에 위치시키면 됨
        // 점을 테두리로 삼는 직사각형 서치
        val P = List(N) { readLine().split(" ").map(String::toInt).run { Point(first(), last()) } }
        val X = P.map { it.x }
        val Y = P.map { it.y }
        var answer = 0
        for (x in X) {
            for (y in Y) {
                answer = maxOf(answer, P.count { (px, py) -> px in x..x + A && py in y..y + B })
            }
        }
        print(answer)
    }
}