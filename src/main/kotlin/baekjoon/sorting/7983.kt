package baekjoon.sorting

class `7983` {
    private data class Homework(
        val d: Int,
        val t: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val H = List(n) { readLine().split(" ").map(String::toInt).run { Homework(first(), last()) } }
            .sortedByDescending { it.t }

        var lastCut = H.first().t // 최대한의 데드라인
        for (i in 0 until n) {
            lastCut = minOf(lastCut, H[i].t) - H[i].d // 극한의 데드라인에서 숙제하기
        }
        print(lastCut)
    }
}