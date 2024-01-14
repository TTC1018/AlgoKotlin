package baekjoon.greedy

class `30646` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val a = readLine().split(" ").map(String::toLong)

        // ai = aj인 지점 찾기 -> 여러개라도 가장 오른쪽이 최대합임
        // 누적합 + 인덱스 활용
        val P = LongArray(N + 1).apply {
            this[1] = a.first()
            for (i in 2..N) {
                this[i] += (this[i - 1] + a[i - 1])
            }
        }

        val idxes = buildMap<Long, MutableList<Int>> {
            for (i in 0 until N) {
                getOrPut(a[i]) { mutableListOf() }.add(i + 1)
            }
        }

        var answerVal = 0L
        var answerCnt = 0
        for (key in idxes.keys) {
            val (s, e) = idxes[key]!!.first() to idxes[key]!!.last()
            val sumVal = P[e] - P[s - 1]

            if (sumVal > answerVal) {
                answerVal = sumVal
                answerCnt = 1
            } else if (sumVal == answerVal) {
                answerCnt++
            }
        }
        print("$answerVal $answerCnt")
    }
}