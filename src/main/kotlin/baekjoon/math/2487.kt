package baekjoon.math

class `2487` {
    private var N = 0
    private lateinit var A: List<Int>
    private lateinit var counter: IntArray

    private fun search(s: Int, now: Int, cnt: Int) {
        if (counter[now] != 0) {
            // 같은 사이클에 포함된 숫자는 순회 숫자 같음
            counter[s] = counter[now]
            return
        }
        if (A[s] == now) {
            counter[s] = cnt
            return
        }

        search(s, A[now], cnt + 1)
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y > 0) {
            x = y.run {
                y = x % this
                this
            }
        }
        return x
    }

    private fun lcm(a: Int, b: Int): Int = (a / gcd(a, b)) * b

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        A = listOf(-1) + readLine().split(" ").map(String::toInt)
        counter = IntArray(N + 1).apply { this[0] = 1 }
        for (i in 1..N) {
            search(i, A[A[i]], 1)
        }
        print(counter.fold(1) { acc, i -> lcm(acc, i) })
    }
}