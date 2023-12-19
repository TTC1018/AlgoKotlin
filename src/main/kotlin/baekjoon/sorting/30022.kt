package baekjoon.sorting

class `30022` {
    private data class Product(
        val p: Long,
        val q: Long,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, A, B) = readLine().split(" ").map(String::toInt)
        val P = List(N) { readLine().split(" ")
            .map(String::toLong).run { Product(first(), last()) } }
            .withIndex()
            .sortedBy { it.value.run { p - q } }
        print(P.subList(0, A).sumOf { it.value.p } + P.subList(A, N).sumOf { it.value.q })
    }
}