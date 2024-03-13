package baekjoon.graph

class `17204` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val a = List(N) { readLine().toInt() }
        val V = BooleanArray(N) { false }
        var s = 0
        var answer = 0
        while (V[s].not()) {
            V[s] = true
            if (s == K)
                break

            s = a[s]
            answer++
        }
        if (V[K]) {
            print(answer)
        } else {
            print(-1)
        }
    }
}