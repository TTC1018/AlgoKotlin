package baekjoon.sorting

class `23279` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val O = List(K) { readLine().split(" ").map(String::toInt).drop(1).sorted() }
        print(O.map { it.mapIndexed { i, v -> v + i + 1 } }.joinToString("\n") { it.joinToString(" ") })
    }
}