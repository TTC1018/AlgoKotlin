package baekjoon.segment_tree

class `12837` {

    private var N = 0
    private var Q = 0
    private lateinit var M: IntArray
    private lateinit var sTree: LongArray

    private fun rangeSum(ns: Int, ne: Int, ts: Int, te: Int, idx: Int): Long {
        if (ns > te || ne < ts)
            return 0
        if (ts <= ns && ne <= te)
            return sTree[idx]

        val mid = (ns + ne) / 2
        return rangeSum(ns, mid, ts, te, idx * 2) + rangeSum(mid + 1, ne, ts, te, idx * 2 + 1)
    }

    private fun update(start: Int, end: Int, node: Int, new: Int, idx: Int){
        if (node in start..end){
            if (start == end){
                sTree[idx] += new.toLong()
                return
            }

            val mid = (start + end) / 2
            update(start, mid, node, new ,idx * 2)
            update(mid + 1, end, node, new, idx * 2 + 1)
            sTree[idx] = sTree[idx * 2] + sTree[idx * 2 + 1]
        }
    }


    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map { it.toInt() }
            .also { N = it.first(); Q = it.last() }
        M = IntArray(N)
        sTree = LongArray(N * 4)

        val sb = StringBuilder()
        repeat(Q) {

            val (op, a, b) = readLine().split(" ").map { it.toInt() }
            when (op) {
                1 -> {
                    update(0, N - 1, a - 1, b, 1)
                    M[a - 1] += b
                }
                2 -> sb.append("${rangeSum(0, N - 1, a - 1, b - 1, 1)}\n")
            }

        }
        print(sb.toString())
    }


}

fun main() {

    `12837`().solution()

}