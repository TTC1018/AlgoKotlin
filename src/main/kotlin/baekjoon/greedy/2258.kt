package baekjoon.greedy

class `2258` {

    private var N = 0
    private var M = 0
    private val meats = mutableListOf<Meat>()

    data class Meat(
        val w:Int,
        val p:Int
    ):Comparable<Meat> {
        override fun compareTo(other: Meat): Int {
            return when {
                p > other.p -> 1
                p < other.p -> -1
                else -> {
                    when {
                        w > other.w -> -1
                        w < other.w -> 1
                        else -> 0
                    }
                }
            }
        }

        operator fun plus(other: Meat): Meat {
            return Meat(w + other.w, p + other.p)
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map { it.toInt() }
            .also {
                N = it.first()
                M = it.last()
            }

        repeat(N) {
            readLine().split(" ").map { it.toInt() }
                .also { meats.add(Meat(it.first(), it.last())) }
        }

        meats.sort()
        val prefix = Array(N) { Meat(0, 0) }.also {
            it[0] = meats.first()
            for (i in 1 until N){
                it[i] = if (meats[i].p == meats[i - 1].p)
                    it[i - 1] + meats[i]
                else
                    Meat(it[i - 1].w + meats[i].w, meats[i].p)
            }
        }

        prefix.sort()
        for (i in 0 until N){
            if (prefix[i].w >= M){
                print(prefix[i].p)
                return
            }
        }

        print(-1)
    }

}

fun main() {

    `2258`().solution()

}