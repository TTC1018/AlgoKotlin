package baekjoon.sorting

class `23740` {
    data class Route(
        val s: Int,
        val e: Int,
        val c: Int
    ) { override fun toString() = "$s $e $c" }

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val B = Array(N) {
            readLine().split(" ").map(String::toInt).let { Route(it[0], it[1], it[2]) }
        }.sortedWith(compareBy({ it.s }, { it.e }))

        buildList {
            var (start, endLoc, minVal) = B.first()
            for (i in 1 until N) {
                val (s, e, c) = B[i]

                if (s <= endLoc) {
                    endLoc = maxOf(endLoc, e)
                    minVal = minOf(minVal, c)
                } else {
                    add(Route(start, endLoc, minVal))
                    start = s
                    endLoc = e
                    minVal = c
                }
            }
            add(Route(start, endLoc, minVal))
        }.also { print("${it.size}\n${it.joinToString("\n")}") }
    }

}

fun main() { `23740`().solution() }