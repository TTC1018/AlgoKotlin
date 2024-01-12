package baekjoon.divideandconquer

class `24460` {
    private var N = 0
    private lateinit var B: List<List<Int>>

    private fun dAndC(tx: Int, ty: Int, size: Int): Int {
        if (size == 1) {
            return B[tx][ty]
        }

        val half = size / 2
        val lt = dAndC(tx, ty, half)
        val rt = dAndC(tx, ty + half, half)
        val ld = dAndC(tx + half, ty, half)
        val rd = dAndC(tx + half, ty + half, half)
        return intArrayOf(lt, rt, ld, rd).sortedArray()[1]
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        B = List(N) { readLine().split(" ").map(String::toInt) }
        print(dAndC(0, 0, N))
    }
}