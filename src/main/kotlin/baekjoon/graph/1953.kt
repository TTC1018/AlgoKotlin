package baekjoon.graph

class `1953` {
    private var n = 0
    private lateinit var H: List<Set<Int>>
    private val B = mutableSetOf<Int>()
    private val W = mutableSetOf<Int>()

    private fun split(now: Int) {
        if (now !in B && now !in W) {
            if (H[now].any { it in B }) {
                W.add(now)
            } else {
                B.add(now)
            }
        }

        for (hate in H[now]) {
            if (hate !in B && hate !in W) {
                if (now in B) {
                    W.add(hate)
                } else {
                    B.add(hate)
                }
                split(hate)
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        n = readLine().toInt()
        H = List(n) { readLine().trim().split(" ").drop(1).map { it.toInt() - 1 }.toSet() }

        for (i in H.indices) {
            split(i)
        }
        println("${B.size}\n${B.sorted().joinToString(" ") { "${it + 1}" }}")
        print("${W.size}\n${W.sorted().joinToString(" ") { "${it + 1}" }}")
    }
}