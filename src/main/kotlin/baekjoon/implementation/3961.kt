package baekjoon.implementation

import kotlin.math.absoluteValue

class `3961` {
    private data class Loc(
        val x: Int,
        val y: Int,
    )

    private data class WordAndDist(
        val word: String,
        val dist: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val t = readLine().toInt()
        val qt = buildMap {
            "qwertyuiop".forEachIndexed { i, c -> put(c, Loc(0, i)) }
            "asdfghjkl".forEachIndexed { i, c -> put(c, Loc(1, i)) }
            "zxcvbnm".forEachIndexed { i, c -> put(c, Loc(2, i)) }
        }
        repeat(t) {
            val wl = readLine().split(" ")
            val word = wl.first()
            val l = wl.last().toInt()
            val S = List(l) { readLine() }.map {
                val dist = word.zip(it)
                    .map { (p, n) -> (qt[p]!!.x - qt[n]!!.x).absoluteValue + (qt[p]!!.y - qt[n]!!.y).absoluteValue }
                    .sumOf { it }
                WordAndDist(it, dist)
            }.sortedWith(compareBy({it.dist}, {it.word}))
            println(S.joinToString("\n") { "${it.word} ${it.dist}" })
        }
    }
}