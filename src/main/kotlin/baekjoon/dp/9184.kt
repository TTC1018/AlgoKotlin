package baekjoon.dp

class `9184` {

    private val dp = Array(21) { Array(21) { Array(21) { 0 } } }

    fun solution() = with(System.`in`.bufferedReader()) {

        while (true) {
            val (a, b, c) = readLine().split(" ").map { it.toInt() }
            if (a == -1 && b == -1 && c == -1)
                break

            println("w($a, $b, $c) = ${w(a, b, c)}")
        }

    }

    private fun w(a: Int, b: Int, c: Int): Int {
        var wa = a
        var wb = b
        var wc = c

        if (wa <= 0 || wb <= 0 || wc <= 0)
            return 1
        else if (wa > 20 || wb > 20 || wc > 20){
            wa = 20; wb = 20; wc = 20
        }

        if (dp[wa][wb][wc] != 0)
            return dp[wa][wb][wc]

        return if (wb in (wa + 1) until wc) {
            dp[wa][wb][wc] = w(wa, wb, wc - 1) + w(wa, wb - 1, wc - 1) - w(wa, wb - 1, wc)
            dp[wa][wb][wc]
        } else {
            dp[wa][wb][wc] = w(wa - 1, wb, wc) + w(wa - 1, wb - 1, wc) + w(wa - 1, wb, wc - 1) - w(wa - 1, wb - 1, wc - 1)
            dp[wa][wb][wc]
        }
    }

}

fun main() {

    `9184`().solution()

}