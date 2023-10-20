package baekjoon.adhoc

class `28359` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val A = readLine().split(" ").map(String::toInt).sorted()
        println(A.sumOf { it } + A.groupingBy { it }.eachCount().maxBy { it.key*it.value }.run { key*value })
        print(A.joinToString(" "))
    }
}