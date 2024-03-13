package baekjoon.binarysearch

class `2295_2` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val U = List(N) { readLine().toInt() }.sorted()
        val twoSum = buildSet {
            for (i in 0 until N) {
                for (j in 0 until N) {
                    add(U[i] + U[j])
                }
            }
        }

        for (i in U.indices.reversed()) {
            for (two in twoSum) {
                val target = U[i] - two
                val search = U.binarySearch(element = target, toIndex = i)
                if (target == search.let { U.getOrNull(it) }) {
                    print(U[i])
                    return
                }
            }
        }
    }
}