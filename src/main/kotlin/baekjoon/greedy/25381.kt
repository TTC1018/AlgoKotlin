package baekjoon.greedy

class `25381` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val S = readLine()
        val q = ArrayDeque<Int>()
        val removed = mutableSetOf<Int>()

        var answer = 0
        for (i in S.indices) {
            when (S[i]) {
                'B' -> q.addLast(i)
                'C' -> {
                    q.removeFirstOrNull()?.let {
                        removed.add(it)
                        answer++
                    }
                }
            }
        }

        q.clear()
        var aCnt = 0
        for (i in S.indices) {
            when (S[i]) {
                'A' -> aCnt++
                'B' -> {
                    if (i !in removed) {
                        aCnt.takeIf { it > 0 }
                            ?.let {
                                removed.add(it)
                                aCnt--
                                answer++
                            }
                    }
                }
            }
        }

        print(answer)
    }
}

fun main() {
    `25381`().solution()
}