package baekjoon.queue

class `3078` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val name = List(N) { readLine().length }
        // K 이하면서 길이가 같은 친구
        // N = 300000, K 다 확인하기에는 수가 너무 큼
        val counter = IntArray(20 + 1)
        val q = ArrayDeque<Int>()
        var answer = 0L
        for (n in name) {
            if (q.size > K) {
                val popped = q.removeFirst()
                counter[popped]--
            }

            answer += counter[n]
            counter[n]++
            q.add(n)
        }
        print(answer)
    }
}