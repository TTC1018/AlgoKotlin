package baekjoon.sorting

class `30619` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val A = readLine().split(" ").map(String::toInt).toIntArray()
        val idx = IntArray(N + 1).apply {
            for (i in 0 until N) {
                this[A[i]] = i
            }
        }
        val M = readLine().toInt()
        val sb = StringBuilder()
        repeat(M) {
            val (L, R) = readLine().split(" ").map(String::toInt)
            val idxes = (L..R).map { idx[it] }.sorted()
            val cloned = A.clone().apply {
                for (i in 0 until idxes.size) {
                    this[idxes[i]] = L + i
                }
            }
            sb.appendLine(cloned.joinToString(" "))
        }
        print(sb.dropLast(1))
    }
}