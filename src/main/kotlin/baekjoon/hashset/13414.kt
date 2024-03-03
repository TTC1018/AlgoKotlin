package baekjoon.hashset

class `13414` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (K, L) = readLine().split(" ").map(String::toInt)
        val clicked = LinkedHashSet<String>().apply {
            repeat(L) {
                val N = readLine()
                if (N in this) {
                    remove(N)
                }
                add(N)
            }
        }
        print(clicked.take(K).joinToString("\n"))
    }
}