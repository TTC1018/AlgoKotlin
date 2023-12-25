package baekjoon.dp

class `15966` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val a = readLine().split(" ").map(String::toInt)
        val idxes = buildMap<Int, MutableList<Int>> {
            a.forEachIndexed { i, v ->
                getOrPut(v) { mutableListOf() }.add(i)
            }
        }
        // a1 + (i-1) = ai
        val dp = IntArray(a.maxOf { it } + 1) { 1 }
        var answer = 1
        for (i in 1 until N) {
            idxes[a[i] - 1]?.let {
                var (l, r) = 0 to it.size - 1
                var target = i
                while (l <= r) {
                    val m = (l+r).div(2)

                    if (it[m] < i) {
                        target = it[m]
                        l = m + 1
                    } else {
                        r = m - 1
                    }
                }

                if (target < i) {
                    dp[a[i]] = maxOf(dp[a[i]], dp[a[target]] + 1)
                    answer = maxOf(answer, dp[a[i]])
                }
            }
        }
        print(answer)
    }
}