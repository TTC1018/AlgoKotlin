package baekjoon.dp

class `28360` {
    private var N = 0
    private var M = 0
    private lateinit var B: List<MutableList<Int>>
    private lateinit var water: DoubleArray
    private var answer = Double.MIN_VALUE

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); M = last()
        }
        B = List<MutableList<Int>>(N+1) { mutableListOf() }.apply {
            repeat(M) {
                val (v, w) = readLine().split(" ").map(String::toInt)
                this[v].add(w)
            }
        }
        water = DoubleArray(N+1).apply { this[1] = 100.0 }
        for (num in 1..N) {
            if (B[num].isEmpty()) {
                answer = maxOf(answer, water[num])
                continue
            }

            for (next in B[num]) {
                water[next] += water[num].div(B[num].size)
            }
        }
        print(answer)
    }
}