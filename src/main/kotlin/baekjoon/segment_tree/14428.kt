package baekjoon.segment_tree

import kotlin.math.min

class `14428` {

    data class Node(
        val value:Int,
        val idx: Int
    ):Comparable<Node> {
        override fun compareTo(other:Node): Int{
            return if (value != other.value)
                value.compareTo(other.value)
            else
                idx.compareTo(other.idx)
        }

        override fun toString() = (idx + 1).toString()
    }

    private var N = 0
    private var M = 0
    private lateinit var A: IntArray
    private lateinit var sTree: Array<Node>

    private fun generateTree(start: Int, end: Int, idx: Int): Node {

        if (start == end) {
            sTree[idx] = Node(A[start], start)
            return sTree[idx]
        }

        val mid = (start + end) / 2
        sTree[idx] = minOf(generateTree(start, mid, idx * 2), generateTree(mid + 1, end, idx * 2 + 1))
        return sTree[idx]

    }

    private fun search(ns:Int, ne:Int, ts:Int, te:Int, idx:Int): Node{
        if (ns > te || ne < ts)
            return Node(1e9.toInt(), N)
        if (ts <= ns && ne <= te){
            return sTree[idx]
        }

        val mid = (ns + ne) / 2
        return minOf(search(ns, mid, ts, te, idx * 2), search(mid + 1, ne, ts, te, idx * 2 + 1))
    }

    private fun update(start:Int, end:Int, node:Int, new:Int, idx:Int){
        if (node in start..end){
            if (start == end){
                sTree[idx] = Node(new, node)
                return
            }

            val mid = (start + end) / 2
            update(start, mid, node, new, idx * 2)
            update(mid + 1, end, node, new, idx * 2 + 1)
            sTree[idx] = minOf(sTree[idx * 2], sTree[idx * 2 + 1])
        }
    }


    fun solution() = with(System.`in`.bufferedReader()) {

        N = readLine().toInt()
        A = readLine().split(" ").map { it.toInt() }.toIntArray()
        M = readLine().toInt()
        sTree = Array(N * 4) { Node(1e9.toInt(), -1)  }
        generateTree(0, N - 1, 1)

        val sb = StringBuilder()
        repeat(M) {

            val (op, a, b) = readLine().split(" ").map { it.toInt() }
            when (op) {
                1 -> {
                    update(0, N - 1, a - 1, b, 1)
                    A[a - 1] = b
                }
                2 -> sb.append("${search(0, N - 1, a - 1, b - 1, 1)}\n")
            }

        }
        print(sb.toString())
    }

}

fun main() {

    `14428`().solution()

}