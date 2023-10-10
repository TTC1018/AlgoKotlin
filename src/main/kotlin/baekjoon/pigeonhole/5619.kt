package baekjoon.pigeonhole

class `5619` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val a = IntArray(n) { readLine().toInt() }.sortedArray()
        print(
            buildList {
                repeat((4).coerceAtMost(n)) { i ->
                    repeat((4).coerceAtMost(n)) { j ->
                        if (i != j) {
                            add("${a[i]}${a[j]}".toInt())
                        }
                    }
                }
            }.sorted()[2]
        )
    }
}

fun main() {
    `5619`().solution()
}