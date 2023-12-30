package baekjoon.slidingwindow

class `25603` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val C = readLine().split(" ").map(String::toInt)

        var ptr = 0
        var answer = -1
        var tempAnswer = Int.MAX_VALUE
        val removeIdx = ArrayDeque<Int>()
        val q = ArrayDeque<IndexedValue<Int>>()
        while (ptr < N) {
            if (q.size < K) {
                q.add(IndexedValue(ptr, C[ptr]))

                if (C[ptr] < tempAnswer) {
                    tempAnswer = C[ptr]
                    removeIdx.clear()
                    removeIdx.add(ptr)
                } else if (C[ptr] == tempAnswer) {
                    removeIdx.add(ptr)
                }
                ptr++
            } else {
                while (q.isNotEmpty() && q.first().index <= removeIdx.first()) {
                    q.removeFirst()
                }

                answer = maxOf(answer, tempAnswer)
                ptr = removeIdx.removeFirst()+1
                q.clear()
                tempAnswer = Int.MAX_VALUE
            }
        }

        if (q.size == K)
            answer = maxOf(answer, tempAnswer)
        print(answer)
    }
}