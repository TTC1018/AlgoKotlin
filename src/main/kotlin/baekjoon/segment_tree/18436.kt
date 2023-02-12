package baekjoon.segment_tree

class `18436` {

    private var N = 0
    private lateinit var A: IntArray
    private var M = 0
    private lateinit var sTree: Array<OddEven>

    data class OddEven(
        val odd: Int,
        val even: Int
    ) {
        operator fun plus(other: OddEven) =
            OddEven(odd + other.odd, even + other.even)
    }

    private fun generateTree(start: Int, end: Int, idx: Int): OddEven {
        if (start == end) {
            sTree[idx] = when (A[start] % 2) {
                0 -> OddEven(0, 1)
                else -> OddEven(1, 0)
            }
            return sTree[idx]
        }

        val mid = (start + end) / 2
        sTree[idx] = generateTree(start, mid, idx * 2) + generateTree(mid + 1, end, idx * 2 + 1)
        return sTree[idx]
    }

    private fun search(ns: Int, ne: Int, ts: Int, te: Int, idx: Int): OddEven {
        if (ns > te || ne < ts)
            return OddEven(0, 0)
        if (ts <= ns && ne <= te)
            return sTree[idx]

        val mid = (ns + ne) / 2
        return search(ns, mid, ts, te, idx * 2) + search(mid + 1, ne, ts, te, idx * 2 + 1)
    }

    private fun update(start: Int, end: Int, node: Int, evenFlag: Boolean, idx: Int) {
        if (node in start..end) {
            if (start == end) {
                sTree[idx] = when (evenFlag) {
                    true -> OddEven(0, 1)
                    else -> OddEven(1, 0)
                }
                return
            }

            val mid = (start + end) / 2
            update(start, mid, node, evenFlag, idx * 2)
            update(mid + 1, end, node, evenFlag, idx * 2 + 1)
            sTree[idx] = sTree[idx * 2] + sTree[idx * 2 + 1]
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        N = readLine().toInt()
        A = readLine().split(" ").map { it.toInt() }.toIntArray()
        M = readLine().toInt()
        sTree = Array(N * 4) { OddEven(0, 0) }
        generateTree(0, N - 1, 1)

        val answer = mutableListOf<Int>()
        repeat(M) {
            val (op, a, b) = readLine().split(" ").map { it.toInt() }
            when (op) {
                1 -> {
                    update(0, N - 1, a - 1, b % 2 == 0, 1)
                    A[a - 1] = b
                }
                2 -> answer.add(search(0, N - 1, a - 1, b - 1, 1).even)
                3 -> answer.add(search(0, N - 1, a - 1, b - 1, 1).odd)
            }
        }
        print(answer.joinToString("\n"))
    }

}

fun main() {

    `18436`().solution()

}