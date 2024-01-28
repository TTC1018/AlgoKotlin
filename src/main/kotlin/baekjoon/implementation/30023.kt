package baekjoon.implementation

class `30023` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val S = readLine()
        val T = listOf('R', 'G', 'B')
        val idx = mapOf('R' to 0, 'G' to 1, 'B' to 2)
        val gap = buildMap<Char, Map<Char, Int>> {
            put('R', mapOf<Char, Int>('G' to 1, 'B' to 2))
            put('G', mapOf<Char, Int>('B' to 1, 'R' to 2))
            put('B', mapOf<Char, Int>('R' to 1, 'G' to 2))
        }
        val next = buildMap<Char, Map<Int, Char>> {
            put('R', mapOf<Int, Char>(1 to 'G', 2 to 'B'))
            put('G', mapOf<Int, Char>(1 to 'B', 2 to 'R'))
            put('B', mapOf<Int, Char>(1 to 'R', 2 to 'G'))
        }

        var answer = Int.MAX_VALUE
        for (t in 0 until 3) {
            val s = S.toCharArray()
            var tempCnt = 0
            for (i in 0 until N - 2) {
                if (idx[s[i]] != t) {
                    val cnt = gap[s[i]]!![T[t]]!!
                    for (j in i until i + 3) {
                        s[j] = next[s[j]]!![cnt]!!
                    }
                    tempCnt += cnt
                }
            }

            if (s.all { it == T[t] }) {
                answer = minOf(answer, tempCnt)
            }
        }

        if (answer == Int.MAX_VALUE) {
            print(-1)
        } else {
            print(answer)
        }
    }
}