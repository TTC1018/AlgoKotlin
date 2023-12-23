package baekjoon.binarysearch

class `2295` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val U = List(N) { readLine().toLong() }.sorted()
        val sumVal = buildList {
            U.forEach { o1 ->
                U.forEach { o2 ->
                    add(o1 + o2)
                }
            }
        }.sorted()

        var answer = 0L
        for (i in 1 until N) {
            for (j in 0 until i) {
                sumVal.binarySearch(U[i] - U[j])
                    .takeIf { it >= 0 }
                    ?.let { answer = maxOf(answer, U[i]) }
            }
        }
        print(answer)
    }
}