package baekjoon.hashset

class `7511` {
    private lateinit var P: IntArray

    private fun findParent(x: Int): Int {
        if (P[x] != x)
            P[x] = findParent(P[x])
        return P[x]
    }

    private fun unionParent(a: Int, b: Int) {
        val (pa, pb) = findParent(a) to findParent(b)
        if (pa < pb) {
            P[pb] = pa
        } else if (pa > pb) {
            P[pa] = pb
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        repeat(readLine().toInt()) { t ->
            sb.append("Scenario ${t+1}:\n")
            val n = readLine().toInt()
            P = IntArray(n) { it }
            val k = readLine().toInt()
            repeat(k) {
                val (a, b) = readLine().split(" ").map(String::toInt)
                unionParent(a, b)
            }
            val m = readLine().toInt()
            repeat(m) {
                val (u, v) = readLine().split(" ").map(String::toInt)
                if (findParent(u) == findParent(v)) {
                    sb.append(1).append('\n')
                } else {
                    sb.append(0).append('\n')
                }
            }
            sb.append('\n')
        }
        print(sb)
    }
}