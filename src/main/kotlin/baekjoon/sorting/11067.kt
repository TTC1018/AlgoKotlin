package baekjoon.sorting

import kotlin.math.absoluteValue

class `11067` {
    private data class Cafe(
        val x: Int,
        val y: Int,
    ) {
        override fun toString() = "$x $y"
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            val n = readLine().toInt()
            val C = List(n) { readLine().split(" ").map(String::toInt).run { Cafe(first(), last()) } }
            val nums = readLine().split(" ").map(String::toInt).drop(1)
            val ax = mutableListOf<Int>()
            val ay = mutableListOf<Int>()

            val lastX = C.maxOf { it.x }
            val G = List(lastX + 1) { mutableListOf<Int>() }.apply {
                for ((x, y) in C) {
                    this[x].add(y)
                }
                forEach { it.sort() }
            }

            var lastY = 0
            for (i in 0..lastX) {
                if (G[i].isNotEmpty()) {
                    if (G[i].size == 1) {
                        lastY = G[i].first()
                        ax.add(i)
                        ay.add(G[i].first())
                    } else {
                        if ((G[i].first() - lastY).absoluteValue < (G[i].last() - lastY).absoluteValue) {
                            lastY = G[i].last()
                            for (y in G[i]) {
                                ax.add(i)
                                ay.add(y)
                            }
                        } else {
                            lastY = G[i].first()
                            for (y in G[i].reversed()) {
                                ax.add(i)
                                ay.add(y)
                            }
                        }
                    }
                }
            }
            sb.append(nums.joinToString("\n") { "${ax[it-1]} ${ay[it-1]}" }).append('\n')
        }
        print(sb.dropLast(1))
    }
}