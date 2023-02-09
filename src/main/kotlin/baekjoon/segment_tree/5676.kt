package baekjoon.segment_tree

class `5676` {

    private lateinit var X: IntArray
    private lateinit var sTree: CharArray

    private fun generateTree(start: Int, end: Int, idx: Int): Char {
        if (start == end) {
            sTree[idx] = when {
                X[start] > 0 -> '+'
                X[start] < 0 -> '-'
                else -> '0'
            }
            return sTree[idx]
        }

        val mid = (start + end) / 2
        val left = generateTree(start, mid, idx * 2)
        val right = generateTree(mid + 1, end, idx * 2 + 1)

        sTree[idx] = when {
            left == '0' || right == '0' -> '0'
            left == right -> '+'
            else -> '-'
        }
        return sTree[idx]
    }

    private fun rangeProduct(ns:Int, ne:Int, ts:Int, te:Int, idx:Int): Char{
        if (ns > te || ne < ts)
            return '+'
        if (ts <= ns && ne <= te)
            return sTree[idx]

        val mid = (ns + ne) / 2
        val left = rangeProduct(ns, mid, ts, te, idx * 2)
        val right = rangeProduct(mid + 1, ne, ts, te, idx * 2 + 1)

        val result = when {
            left == '0' || right == '0' -> '0'
            left == right -> '+'
            else -> '-'
        }
        return result
    }

    private fun updateTree(start:Int, end:Int, node:Int, new:Int, idx:Int){
        if (node in start..end){
            if (start == end){
                sTree[idx] = when {
                    new > 0 -> '+'
                    new < 0 -> '-'
                    else -> '0'
                }
                return
            }

            val mid = (start + end) / 2
            updateTree(start, mid, node, new, idx * 2)
            updateTree(mid + 1, end, node, new, idx * 2 + 1)

            val left = sTree[idx * 2]
            val right = sTree[idx * 2 + 1]
            sTree[idx] = when {
                left == '0' || right == '0' -> '0'
                left == right -> '+'
                else -> '-'
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        while (true) {

            try {
                val (N, K) = readLine().split(" ").map { it.toInt() }
                X = readLine().split(" ").map { it.toInt() }.toIntArray()
                sTree = CharArray(N * 4)
                generateTree(0, N - 1, 1)

                val answer = StringBuilder()

                for (i in 1..K) {
                    val read = readLine()
                    if (read.isNullOrEmpty())
                        break
                    val (op, a, b) = read.split(" ")

                    when (op) {
                        "C" -> {
                            updateTree(0, N - 1, a.toInt() - 1, b.toInt(), 1)
                            X[a.toInt() - 1] = b.toInt()
                        }
                        "P" -> {
                            val result = rangeProduct(0, N - 1, a.toInt() - 1, b.toInt() - 1, 1)
                            answer.append(result)
                        }
                    }
                }

                println(answer.toString())

            } catch (e: Exception) {
                break
            }

        }

    }

}

fun main() {

    `5676`().solution()

}