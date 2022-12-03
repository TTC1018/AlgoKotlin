package baekjoon.greedy

class `1041` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val dice = readLine().split(" ").map { it.toInt() }
        if (N == 1){
            print(dice.sumOf { it } - dice.maxOf { it })
            return
        }

        val aToIdx = mapOf('A' to 0, 'B' to 1, 'C' to 2, 'D' to 3, 'E' to 4, 'F' to 5)
        val neighbor = mapOf(
            'A' to listOf(Pair('B', 'C'), Pair('B', 'D'), Pair('E', 'C'), Pair('E', 'D')),
            'B' to listOf(Pair('A', 'C'), Pair('A', 'D'), Pair('F', 'C'), Pair('F', 'D')),
            'C' to listOf(Pair('A', 'B'), Pair('A', 'E'), Pair('F', 'B'), Pair('F', 'E')),
            'D' to listOf(Pair('A', 'B'), Pair('A', 'E'), Pair('F', 'B'), Pair('F', 'B')),
            'E' to listOf(Pair('A', 'C'), Pair('A', 'D'), Pair('F', 'C'), Pair('F', 'D')),
            'F' to listOf(Pair('B', 'C'), Pair('B', 'D'), Pair('E', 'C'), Pair('E', 'D')),
        )

        val smallest = dice.minOf { it }.toLong()
        // 3개합 최소 -> 4개 고정
        // 2개합 최소 -> 4 * (N - 2 + N - 1)
        // 1개합 최소 -> (N-2)^2 + 4*(N-2) * (N-1)

        val triples = mutableSetOf<Int>()
        val doubles = mutableSetOf<Int>()

        neighbor.keys.forEach { key ->
            neighbor[key]?.forEach { (n1, n2) ->
                triples.add(dice[aToIdx[key]!!] + dice[aToIdx[n1]!!] + dice[aToIdx[n2]!!])
                doubles.add(dice[aToIdx[n1]!!] + dice[aToIdx[n2]!!])
            }
        }

        val minTriple = triples.minOf { it }.toLong()
        val minDouble = doubles.minOf { it }.toLong()

        val top = (minTriple * 4) + (minDouble * (N - 2) * 4) + (smallest * (N - 2) * (N - 2))
        val under = (minDouble * 4 + smallest * (N - 2) * 4) * (N - 1)
        print(top + under)
    }

}

fun main() {

    `1041`().solution()

}