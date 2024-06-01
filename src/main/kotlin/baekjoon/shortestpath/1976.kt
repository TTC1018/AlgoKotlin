package baekjoon.shortestpath

class `1976` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val M = readLine().toInt()
        val B = List(N) {
            readLine().split(" ").map(String::toInt).toIntArray().apply {
                this[it] = 1
            }
        }
        val R = readLine().split(" ").map { it.toInt() - 1 }
        for (k in 0 until N) {
            for (i in 0 until N) {
                for (j in 0 until N) {
                    if (B[i][k] == 1 && B[k][j] == 1)
                        B[i][j] = 1
                }
            }
        }
        R.zipWithNext { a: Int, b: Int ->
            if (B[a][b] != 1) {
                print("NO")
                return@with
            }
        }
        print("YES")
    }
}