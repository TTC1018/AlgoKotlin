package baekjoon.tree


import java.util.TreeSet


class `23326` {
    private var N = 0
    private var Q = 0
    private var now = 0
    private val places = TreeSet<Int>()

    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map { it.toInt() }
            .also { N = it.first(); Q = it.last() }
        readLine().split(" ").map { it.toInt() }
            .forEachIndexed { i, v -> if (v == 1) places.add(i) }

        repeat(Q) {
            val ops = readLine().split(" ").map { it.toInt() }
            when (ops.first()) {
                1 -> {
                    val idx = ops.last().toInt() - 1
                    if (idx in places)
                        places.remove(idx)
                    else
                        places.add(idx)
                }

                2 -> {
                    val step = ops.last()
                    now = (now + step) % N
                }

                3 -> {
                    val left = places.firstOrNull()
                    val right = places.ceiling(now)

                    println(
                        when {
                            right != null -> right - now
                            left != null -> N - now + left
                            else -> -1
                        }
                    )
                }
            }
        }
    }

}


fun main() {

    `23326`().solution()

}