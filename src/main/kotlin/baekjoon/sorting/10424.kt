package baekjoon.sorting

class `10424` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val S = readLine().split(" ").map(String::toInt).withIndex()
            .sortedWith(compareBy({ it.value }, { it.index }))
        print(S.map { (i, v) -> v - (i + 1) }.joinToString("\n"))
    }
}