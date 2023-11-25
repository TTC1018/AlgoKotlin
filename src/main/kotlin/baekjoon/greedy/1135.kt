package baekjoon.greedy

class `1135` {
    private var N = 0
    private lateinit var T: List<MutableList<Int>>

    private fun dfs(now: Int): Int {
        if (T[now].isEmpty())
            return 0

        // 자식 중에 가장 오래걸리는 것부터 처리
        // 하나씩 처리하기 때문에 기다린 시간을 더해주어야 함
        return T[now].map { dfs(it) }
            .sortedDescending()
            .mapIndexed { i, v -> (i + 1) + v }
            .maxOf { it }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        T = List<MutableList<Int>>(N) { mutableListOf() }.apply {
            val parent = readLine().split(" ").map(String::toInt)
            for (i in 1 until N) {
                this[parent[i]].add(i)
            }
        }

        print(dfs(0))
    }
}