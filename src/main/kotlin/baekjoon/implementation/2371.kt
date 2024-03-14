package baekjoon.implementation

class `2371` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val F = List(N) { readLine().split(" ").map(String::toInt).dropLast(1) }
        val maxLength = F.maxOf { it.size }

        val S = List(N) { StringBuilder() }
        val temp = mutableSetOf<String>()
        for (i in 0 until maxLength) {
            temp.clear()
            for (j in F.indices) {
                F[j].getOrElse(i) { 0 }.let {
                    temp.add(S[j].append(it).toString())
                }
            }
            if (temp.size == N) {
                print(i + 1)
                return
            }
        }
    }
}