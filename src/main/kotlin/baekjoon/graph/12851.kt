package baekjoon.graph

class `12851` {

    data class Pos(
        val x: Int,
        val count: Int
    ) : Comparable<Pos> {
        override fun compareTo(other: Pos): Int =
            this.count.compareTo(other.count)
    }

    private val queue = ArrayDeque<Pos>()

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, K) = readLine().split(" ").map { it.toInt() }
        val visited = BooleanArray(100000 + 1) { false }
        queue.add(Pos(N, 0))

        var answerVal = Int.MAX_VALUE
        var answerCnt = 0
        while (queue.isNotEmpty()) {
            val (now, count) = queue.removeFirst()
            if (now == K) {
                when {
                    answerVal < count -> break
                    answerVal == count -> answerCnt++
                    answerVal == Int.MAX_VALUE -> {
                        answerVal = count
                        answerCnt++
                    }
                }
                continue
            }

            visited[now] = true
            if (now - 1 >= 0 && visited[now - 1].not()) {
                queue.add(Pos(now - 1, count + 1))
            }
            if (now + 1 <= 100000 && visited[now + 1].not()) {
                queue.add(Pos(now + 1, count + 1))
            }
            if (now * 2 <= 100000 && visited[now * 2].not()) {
                queue.add(Pos(now * 2, count + 1))
            }

        }

        print("$answerVal\n$answerCnt")
    }

}

fun main() {

    `12851`().solution()

}