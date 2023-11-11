package baekjoon.greedy

class `26648` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val ABC = List(N) { IntArray(3) }.apply {
            repeat(3) {
                readLine().split(" ").map(String::toInt).forEachIndexed { i, v ->
                    this[i][it] = v
                }
            }

            for (i in 0 until N)
                this[i].sort()
        }

        var minVal = ABC.first().first()
        for (i in 1 until N) {
            if (minVal >= ABC[i].last()) {
                print("NO")
                return
            }
            minVal = maxOf(minVal + 1, ABC[i].first())
        }
        print("YES")
    }
}