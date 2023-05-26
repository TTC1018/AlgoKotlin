package baekjoon.binarysearch

import kotlin.math.absoluteValue

class `8983` {

    data class Loc(
        val a: Int,
        val b: Int
    )

    fun solution() = with(System.`in`.bufferedReader()) {

        val (M, N, L) = readLine().split(" ").map { it.toInt() }
        val x = readLine().split(" ").map { it.toInt() }.sorted().toIntArray()
        val animal = Array(N) { readLine().split(" ").map { it.toInt() }.let { Loc(it.first(), it.last()) } }

        var answer = 0
        for ((a, b) in animal) {

            var left = 0
            var right = M - 1
            while (left <= right) {
                val mid = (left + right) / 2

                when {
                    x[mid] == a -> {
                        left = mid
                        break
                    }
                    x[mid] > a -> right = mid - 1
                    x[mid] < a -> left = mid + 1
                }
            }

            when {
                left < M && (x[left] - a).absoluteValue + b <= L -> answer++
                left > 0 && ((x[left - 1] - a).absoluteValue + b <= L) -> answer++
                left < M - 1 && ((x[left + 1] - a).absoluteValue + b <= L) -> answer++
            }
        }
        print(answer)
    }

}

fun main() {

    `8983`().solution()

}