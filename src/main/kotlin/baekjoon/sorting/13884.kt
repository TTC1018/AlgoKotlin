package baekjoon.sorting

class `13884` {
    fun solution() = with(System.`in`.bufferedReader()) {
        print(
            buildList {
                repeat(readLine().toInt()) { i ->
                    val (K, N) = readLine().split(" ").map(String::toInt)
                    val nums = buildList {
                        while (size < N) {
                            addAll(readLine().split(" ").map(String::toInt))
                        }
                    }
                    val numsSorted = nums.sorted()
                    var target = 0
                    for (j in 0 until N) {
                        if (nums[j] == numsSorted[target]) {
                            target++
                        }
                    }
                    add("$K ${N - target}")
                }
            }.joinToString("\n")
        )
    }
}