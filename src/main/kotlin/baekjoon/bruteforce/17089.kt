package baekjoon.bruteforce

class `17089` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val F = List(N) { mutableSetOf<Int>() }.apply {
            repeat(M) {
                val (a, b) = readLine().split(" ").map { it.toInt() - 1 }
                this[a].add(b)
                this[b].add(a)
            }
        }

        var answer = Int.MAX_VALUE
        for (a in 0 until N) {
            for (b in a+1 until N) {
                if (a in F[b] && b in F[a]) {
                    for (c in F[a].intersect(F[b])) {
                        answer = minOf(answer, F[a].size + F[b].size + F[c].size - 6)
                    }
                }
            }
        }

        if (answer == Int.MAX_VALUE) {
            print(-1)
        } else {
            print(answer)
        }
    }
}