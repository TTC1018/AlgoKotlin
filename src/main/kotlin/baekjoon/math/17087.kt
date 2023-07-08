package baekjoon.math

import kotlin.math.absoluteValue

class `17087` {

    private fun gcd(a: Int, b: Int): Int {
        var (bigger, smaller) = listOf(a, b).sortedDescending()

        while (smaller > 0) {
            val mod = bigger % smaller
            bigger = smaller
            smaller = mod
        }

        return bigger
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, S) = readLine().split(" ").map(String::toInt)
        val A = readLine().split(" ")
            .map { (it.toInt() - S).absoluteValue }.toIntArray()

        print(A.fold(A.first()) { prev, new -> gcd(prev, new) })
    }
}

fun main() {
    `17087`().solution()
}