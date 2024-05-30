package baekjoon.math

class `24516` {
    fun solution() = with(System.`in`.bufferedReader()) {
        print(IntArray(readLine().toInt()) { 1 + 2 * it }.joinToString(" "))
    }
}