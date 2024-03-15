package baekjoon.greedy

class `30701` {
    fun solution() = with(System.`in`.bufferedReader()) {
        var (N, D) = readLine().split(" ").map(String::toLong)
        val M = mutableListOf<Long>()
        val E = mutableListOf<Long>()
        repeat(N.toInt()) {
            val (A, X) = readLine().split(" ").map(String::toLong)
            when (A) {
                1L -> M.add(X)
                2L -> E.add(X)
            }
        }
        M.sort()
        E.sort()

        var mPtr = 0
        var ePtr = 0
        while (mPtr < M.size) {
            if (D > M[mPtr]) {
                D += M[mPtr]
                mPtr++
            } else {
                while (E.getOrNull(ePtr) != null && D <= M[mPtr]) {
                    E.getOrNull(ePtr)?.let {
                        D *= it
                        ePtr++
                    }
                }

                if (D > M[mPtr]) {
                    D += M[mPtr]
                    mPtr++
                } else {
                    break
                }
            }
        }
        print(mPtr + E.size)
    }
}