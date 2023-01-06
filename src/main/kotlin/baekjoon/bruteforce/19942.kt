package baekjoon.bruteforce

class `19942` {

    data class Nutrient(
        val p: Int,
        val f: Int,
        val s: Int,
        val v: Int,
        val c: Int
    ) {
        operator fun plus(other: Nutrient) =
            Nutrient(
                p + other.p,
                f + other.f,
                s + other.s,
                v + other.v,
                c + other.c
            )
    }

    private var answerVal = Int.MAX_VALUE
    private var answerIdx = mutableListOf<List<Int>>()
    private var N = 0
    private lateinit var minVals: IntArray
    private lateinit var foods: List<Nutrient>

    private fun isSatisfied(n: Nutrient) =
        listOf(n.p, n.f, n.s, n.v).withIndex().all {
            it.value >= minVals[it.index]
        }


    private fun bruteforce(now: Int, idxes: List<Int>, total: Nutrient) {
        if (answerVal < total.c)
            return

        if (isSatisfied(total) && answerVal >= total.c) {
            if (answerVal == total.c)
                answerIdx.add(idxes)
            else
                answerIdx = mutableListOf(idxes)
            answerVal = total.c
        }

        for (i in now  until N) {
            bruteforce(i + 1, idxes + listOf(i + 1), total + foods[i])
        }

    }

    fun solution() = with(System.`in`.bufferedReader()) {

        N = readLine().toInt()
        minVals = readLine().split(" ").map { it.toInt() }.toIntArray()
        foods = mutableListOf<Nutrient>().apply {
            repeat(N) {
                val (p, f, s, v, c) = readLine().split(" ").map { it.toInt() }
                add(Nutrient(p, f, s, v, c))
            }
        }

        bruteforce(0, listOf(), Nutrient(0, 0, 0, 0, 0))

        if (answerVal == Int.MAX_VALUE)
            print(-1)
        else {
            answerIdx.sortBy { it.joinToString("") }
            print("$answerVal\n${answerIdx.first().joinToString(" ")}")
        }

    }

}

fun main() {

    `19942`().solution()

}