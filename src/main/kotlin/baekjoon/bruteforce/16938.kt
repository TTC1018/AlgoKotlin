package baekjoon.bruteforce

class `16938` {
    private var N = 0
    private var L = 0
    private var R = 0
    private var X = 0
    private lateinit var A: List<Int>
    private var V = 0
    private var answer = 0

    private fun Int.toBit() = 1 shl this

    private fun bruteforce(minVal: Int, idx: Int, sumVal: Int) {
        if (sumVal > R)
            return

        if (sumVal in L..R && A[idx] - minVal >= X)
            answer++

        for (i in idx + 1 until N) {
            val bit = i.toBit()
            if (V and bit == 0) {
                V = V or bit
                bruteforce(minVal, i, sumVal + A[i])
                V = V xor bit
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); L = this[1]; R = this[2]; X = last()
        }
        A = readLine().split(" ").map(String::toInt).sorted()
        for (i in 0 until N - 1) {
            bruteforce(A[i], i, A[i])
        }
        print(answer)
    }
}