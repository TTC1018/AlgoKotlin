package baekjoon.geometry

class `1709` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toLong()
        val radius = N.div(2)
        val dist: (Long, Long) -> Long = { x, y -> x * x + y * y }

        // 사분면으로 나눠지므로, 하나만 구하고 4 곱하면 된다.
        // 원의 상단 중앙부터 시작해서 둘레에 걸치는 좌표를 트래킹
        var sx = 0L
        var sy = radius - 1
        val rr = radius * radius // 좌표까지의 거리에 루트 없앨 거라 반지름도 제곱해주기

        var answer = 0
        while (sx <= N && 0 <= sy) {

            val d = dist(sx + 1, sy)
            when {
                d == rr -> { sx++; sy-- } // 정확히 통과하므로 x, y 둘 다 변화
                d < rr -> sx++ // 사정거리 안이므로 x 증가
                d > rr -> sy-- // 반지름에 닿도록 y 차감
            }
            answer++

        }
        print(answer * 4)

    }

}

fun main() {

    `1709`().solution()

}