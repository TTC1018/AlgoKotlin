package baekjoon.adhoc

class `27468` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()

        val answer = IntArray(N)
        var cnt = 0
        val plus = if (N % 4 == 1) intArrayOf(1, 2, -1 ,2)  else intArrayOf(2, -1, 2, 1)
        var idx = 0
        var num = 0
        while (cnt < N) {
            num += plus[idx]
            answer[cnt] = num
            cnt++
            idx = (idx + 1) % 4
        }
        println("YES")
        print(answer.joinToString(" "))
    }
}

fun main() { `27468`().solution() }