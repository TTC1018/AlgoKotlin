package baekjoon.greedy

class `11509` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val H = readLine().split(" ").map(String::toInt)
        val counter = IntArray(H.maxOf { it } + 1)
        var answer = 0
        for (i in H.indices) {
            if (counter[H[i]] == 0) {
                answer++
            } else {
                counter[H[i]]--
            }
            counter[H[i] - 1]++
        }
        print(answer)
    }
}