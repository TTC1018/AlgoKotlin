package baekjoon.graph

class `23085` {
    private data class Memo(
        val h: Int,
        val t: Int,
        val cnt: Int = 0,
    )

    private val checked = mutableSetOf<Memo>()

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val S = readLine()
        // 모두 T로 만들기
        // 3000CK 을 계속해서 반복 -> 시간초과
        // 앞 K개든 뒤 K개든 H와 T의 개수만이 중요하다.
        // H 5개 -> H 2개 T 3개 -> H 3개 T 2개 -> T 5개
        val hCnt = S.count { it == 'H' }
        val tCnt = N - hCnt
        checked.add(Memo(hCnt, tCnt))

        val q = ArrayDeque<Memo>().apply { add(Memo(hCnt, tCnt)) }
        while (q.isNotEmpty()) {
            val (h, t, cnt) = q.removeFirst()
            if (h == 0) {
                print(cnt)
                return
            }

            for (revH in 0..K) { // h 뒤집기 개수
                val revK = K - revH // k 뒤집기 개수
                if (h - revH >= 0 && t - revK >= 0) {
                    val diff = (revH - revK)
                    if (Memo(h - diff, t + diff) !in checked) {
                        checked.add(Memo(h- diff, t + diff))
                        q.add(Memo(h - diff, t + diff, cnt + 1))
                    }
                }
            }
        }
        print(-1)
    }
}