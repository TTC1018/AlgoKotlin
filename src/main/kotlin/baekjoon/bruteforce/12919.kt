package baekjoon.bruteforce

class `12919` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val S = readLine()
        val T = readLine()

        // T -> S 간다면
        // 뒤에서 A떼기 or 앞에서 B떼고 뒤집기
        val q = ArrayDeque<String>().apply {
            add(T)
        }

        val visited = mutableSetOf<String>()
        while (q.isNotEmpty()) {
            val s = q.removeFirst()
            if (s.length == S.length) {
                if (s == S) {
                    print(1)
                    return
                }
                continue
            }

            if (s.last() == 'A') {
                val next = s.dropLast(1)
                if (next !in visited) {
                    visited.add(next)
                    q.add(next)
                }
            }
            if (s.first() == 'B') {
                val next = s.drop(1).reversed()
                if (next !in visited) {
                    visited.add(next)
                    q.add(next)
                }
            }
        }
        print(0)
    }
}