package baekjoon.graph

import kotlin.math.pow

class `16397` {
    private data class NumAndCount(
        val num: Int,
        val cnt: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, T, G) = readLine().split(" ").map(String::toInt)
        // 버튼 A, B
        // A: 1 증가
        // B: 2배 증가 후 가장 높은 자리수 1차감
        // 99999 넘으면 실패 (2배 증가했을 때 넘어도 바로 실패)
        // 최대 T번 누를 수 있고, G와 같게 만들기
        val visited = BooleanArray(99999 + 1) { false }.apply {
            this[N] = true
        }
        val q = ArrayDeque<NumAndCount>().apply {
            add(NumAndCount(N, 0))
        }
        while (q.isNotEmpty()) {
            val (num, cnt) = q.removeFirst()
            if (num == G) {
                print(cnt)
                return
            }

            if (num + 1 <= 99999 && cnt < T && visited[num + 1].not()) {
                visited[num + 1] = true
                q.add(NumAndCount(num + 1, cnt + 1))
            }

            val next = (num * 2).run { this - (10.0).pow(this.toString().length - 1).toInt() }
            if (next > 0 && num * 2 <= 99999 && cnt < T && visited[next].not()) {
                visited[next] = true
                q.add(NumAndCount(next, cnt + 1))
            }
        }
        print("ANG")
    }
}