package baekjoon.hashset

class `3018` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val E = readLine().toInt()
        val C = List(E) { readLine().split(" ").drop(1).map(String::toInt).toSet() }
        var sIdx = 10000
        val S = mutableSetOf<Int>()
        val H = List(N + 1) { mutableSetOf<Int>() }
        for (c in C) {
            if (1 in c) {
                for (other in c) {
                    H[other].add(sIdx)
                }
                S.add(sIdx)
                sIdx++
            } else {
                for (parti in c) {
                    for (other in c) {
                        H[parti].addAll(H[other])
                    }
                }
            }
        }

        print(
            H.withIndex().filter { it.value.size == S.size }
                .map { it.index }.joinToString("\n")
        )
    }
}