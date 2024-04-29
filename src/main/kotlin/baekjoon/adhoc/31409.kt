package baekjoon.adhoc

class `31409` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val b = readLine().split(" ").map(String::toInt).toIntArray()
        var answer = 0
        for (i in b.indices) {
            if ((i + 1) == b[i]) {
                answer++
                b[i] = (i + 1) % N + 1
            }
        }
        print("$answer\n${b.joinToString(" ")}")
    }
}