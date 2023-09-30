package baekjoon.graph

class `14226` {
    private data class Clipboard(
        val total: Int,
        val len: Int,
        val cnt: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val S = readLine().toInt()
        val q = ArrayDeque<Clipboard>().apply {
            add(Clipboard(1, 0, 0))
        }
        val visited = List(2000 + 1) { IntArray(2000 + 1) { Int.MAX_VALUE } }
        while (q.isNotEmpty()) {
            val (total, len, cnt) = q.removeFirst()
            if (total == S) {
                print(cnt)
                return
            }

            // 하나 지우기
            if (total - 1 > 0 && visited[total - 1][len] > cnt + 1) {
                visited[total - 1][len] = cnt + 1
                q.add(Clipboard(total - 1, len, cnt + 1))
            }
            // 전체 복사
            if (visited[total][total] > cnt + 1) {
                visited[total][total] = cnt + 1
                q.add(Clipboard(total, total, cnt + 1))
            }
            // 그대로 붙여넣기
            if (len > 0 && total + len <= 2000 && visited[total + len][len] > cnt + 1) {
                visited[total + len][len] = cnt + 1
                q.add(Clipboard(total + len, len, cnt + 1))
            }
        }
    }
}

fun main() {
    `14226`().solution()
}