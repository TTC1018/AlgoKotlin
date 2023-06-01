package baekjoon.prefixsum

class `20438` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, K, Q, M) = readLine().split(" ").map { it.toInt() }
        val slept = BooleanArray(N + 2 + 1) { false }
            .also { s ->
                readLine().split(" ").map { it.toInt() }
                    .forEach { s[it] = true }
            }

        val targets = readLine().split(" ").map { it.toInt() }
        val visited = BooleanArray(N) { false }

        for (target in targets) {
            if (slept[target]) {
                continue
            }

            for (stu in target..N + 2 step target) {
                if (slept[stu].not())
                    visited[stu - 3] = true
            }
        }

        val prefix = IntArray(N)
        prefix[0] = if (visited[0].not()) 1 else 0
        for (num in 1 until N) {
            if (visited[num].not())
                prefix[num] += 1
            prefix[num] += prefix[num - 1]
        }

        val answer = mutableListOf<Int>()
        repeat(M) {

            val (S, E) = readLine().split(" ").map { it.toInt() - 3 }
            answer.add(if (S == 0) prefix[E] else prefix[E] - prefix[S - 1])

        }
        print(answer.joinToString("\n"))
    }

}

fun main() {

    `20438`().solution()

}