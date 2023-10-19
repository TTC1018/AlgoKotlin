package baekjoon.greedy

class `3216` {
    private data class Song(
        val d: Int,
        val v: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val S = List(N) { readLine().split(" ").map(String::toInt).run { Song(first(), last()) } }

        var time = 0 // 필요한 시간
        for ((d, v) in S.reversed()) {
            // 현재 노래를 이어 들으려면
            // v만큼의 시간 + (필요한 시간 - 재생으로 벌 수 있는 시간)이 필요
            time = v + (time - d).coerceAtLeast(0)
        }
        print(time)
    }
}