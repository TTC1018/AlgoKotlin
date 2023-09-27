package baekjoon.baekjoon.divideandconquer

class `16974` {
    private data class Burger(
        val b: Long,
        val p: Long
    ) : Comparable<Long> {

        val total get() = b + p

        operator fun plus(o: Burger) = Burger(b + o.b, p + o.p)

        override fun compareTo(other: Long): Int {
            return (b + p).compareTo(other)
        }
    }

    private lateinit var counter: List<Burger>
    private val bun = Burger(1, 0)
    private val patty = Burger(0, 1)

    private fun dAndQ(level: Int, left: Long): Long {
        if (level == 0)
            return 1
        if (left == 1L)
            return 0

        val half = counter[level - 1].total
        var totalPatty = 0L
        when {
            left == counter[level].total -> {
                totalPatty += counter[level].p
            }
            left == half + 1 -> {
                totalPatty += counter[level - 1].p
            }
            left == half + 2 -> {
                totalPatty++
                totalPatty += counter[level - 1].p
            }
            left < half + 1 -> {
                totalPatty += dAndQ(level - 1, left - 1)
            }
            else -> {
                totalPatty++
                totalPatty += counter[level - 1].p
                totalPatty += dAndQ(level - 1, left - half - 2)
            }
        }
        return totalPatty
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, X) = readLine().split(" ").run { first().toInt() to last().toLong() }
        // B = 0 / P = 1
        // B = 2 / P = 1 + 1*2
        // B = 2 + 2*2 / P = 1 + 3*2
        // 개수 반 이상이면 -> 레벨 N-1 버거의 패티 수 + 나머지
        counter = buildList {
            add(patty)
            repeat(N) {
                add(bun + last() + patty + last() + bun)
            }
        }

        print(dAndQ(N, X))
    }
}

fun main() {
    `16974`().solution()
}