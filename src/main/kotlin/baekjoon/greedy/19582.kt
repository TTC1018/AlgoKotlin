package baekjoon.greedy

class `19582` {
    private data class Contest(
        val x: Int,
        val p: Int
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val C = List(N) { readLine().split(" ").map(String::toInt).run { Contest(first(), last()) } }

        var stacked = 0
        var maxP = 0
        var endFlag = false
        for (i in C.indices) {
            val (x, p) = C[i]

            if (stacked > x) {
                if (endFlag) {
                    print("Zzz")
                    return
                }

                if (maxP > p && stacked - maxP <= x) {
                    stacked -= maxP
                    stacked += p
                }
                endFlag = true
                continue
            }

            stacked += p
            maxP = maxOf(maxP, p)
        }

        print("Kkeo-eok")
    }
}

fun main() {
    `19582`().solution()
}