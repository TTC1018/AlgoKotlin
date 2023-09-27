package baekjoon.baekjoon.greedy

class `20311` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val c = readLine().split(" ")
            .map(String::toInt)
            .withIndex().sortedByDescending { it.value }
            .map { intArrayOf(it.index + 1, it.value) }

        val answer = IntArray(N)
        var aIndex = 0
        val sIndex = 1

        // 짝수 인덱스 다 메꾸고 홀수 인덱스 메꾸기
        for (i in c.indices) {
            repeat(c[i][1]) {
                if (aIndex >= 1 && answer[aIndex - 1] == c[i][0]) {
                    print(-1)
                    return
                }

                answer[aIndex] = c[i][0]
                aIndex += 2
                if (aIndex >= N) { // 짝수 인덱스 끝났으면 홀수 인덱스로
                    aIndex = sIndex
                }
            }
        }

        print(answer.joinToString(" "))
    }
}

fun main() {
    `20311`().solution()
}