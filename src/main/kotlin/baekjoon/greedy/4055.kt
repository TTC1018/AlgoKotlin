package baekjoon.greedy

class `4055` {
    private data class Party(
        val s: Double,
        val e: Double
    ) : Comparable<Party> {
        override fun compareTo(other: Party): Int {
            if (e == other.e)
                return other.s.compareTo(s)
            return e.compareTo(other.e)
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        var order = 1
        while (true) {
            val n = readLine().trim().toInt()
            if (n == 0)
                break

            val P = buildList {
                repeat(n) {
                    val party = readLine().trim().split(" ").map(String::toDouble).run { Party(first(), last() - 0.5) }
                    if (party.s <= party.e) {
                        add(party)
                    }
                }
            }.sorted()

            var answer = 0
            val removed = BooleanArray(n) { false }
            for (t in 8..23) {
                repeat(2) { // 시간마다 2번의 참여 기회가 있다.
                    for (i in P.indices) {
                        val (s, e) = P[i]
                        if (removed[i].not() && s <= t && t <= e) {
                            removed[i] = true
                            answer++
                            break
                        }
                    }
                }
            }

            println("On day $order Emma can attend as many as $answer parties.")
            order++
        }

    }
}

fun main() {
    `4055`().solution()
}