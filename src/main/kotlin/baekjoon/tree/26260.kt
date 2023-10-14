package baekjoon.tree

class `26260` {
    private var N = 0
    private lateinit var T: IntArray
    private val answer = mutableListOf<Int>()

    private fun postorder(idx: Int, depth: Int) {
        if (depth == 0) {
            answer.add(T[idx])
            return
        }

        postorder(idx - depth, depth.div(2))
        postorder(idx + depth, depth.div(2))
        answer.add(T[idx])
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        T = readLine().split(" ").map(String::toInt).toIntArray()
            .also {
                for (i in it.indices) {
                    if (it[i] == -1) {
                        it[i] = readLine().toInt()
                        break
                    }
                }
            }.sortedArray()

        postorder(N.div(2), (N+1).div(2*2))
        print(answer.joinToString(" "))
    }
}