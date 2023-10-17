package baekjoon.graph

import kotlin.system.exitProcess

class `25601` {
    private var N = 0
    private val parent = mutableMapOf<String, MutableSet<String>>()
    private val child = mutableMapOf<String, MutableSet<String>>()
    private lateinit var A: String
    private lateinit var B: String

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()

        repeat(N-1) {
            val (a, b) = readLine().split(" ")
            parent.getOrPut(a) { mutableSetOf() }.add(b)
            child.getOrPut(b) { mutableSetOf() }.add(a)
        }

        readLine().split(" ").run {
            A = first(); B = last()
        }

        goUp(A)
        goDown(A)
        print(0)
    }

    private fun goDown(now: String) {
        if (now == B) {
            print(1)
            exitProcess(0)
        }

        child[now]?.run {
            for (cand in this) {
                goDown(cand)
            }
        }
    }

    private fun goUp(now: String) {
        if (now == B) {
            print(1)
            exitProcess(0)
        }

        parent[now]?.run {
            for (cand in this) {
                goUp(cand)
            }
        }
    }
}

fun main() {
    `25601`().solution()
}