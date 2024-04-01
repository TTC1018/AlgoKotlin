package baekjoon.prefixsum

class `20159` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val X = readLine().split(" ").map(String::toLong)
        // 밑장 빼는 순간 앞으로 받을 카드들의 합이 변함
        // 홀수인덱스 짝수인덱스 합 구하기
        val E = LongArray(N).apply {
            this[0] = X.first()
            for (i in 2 until N step 2) {
                this[i] += (this[i - 2] + X[i])
            }
        }
        val O = LongArray(N).apply {
            this[1] = X[1]
            for (i in 3 until N step 2) {
                this[i] += (this[i - 2] + X[i])
            }
        }

        var answer = maxOf(O.last(), O.last() - X.last() + E.first())
        for (i in 2 until N) {
            val temp = if (i and 1 == 0) {
                O.last() - O[i - 1] + E[i - 2]
            } else {
                O.last() - O[i - 2] - X.last() + E[i - 1]
            }
            answer = maxOf(answer, temp)
        }
        print(answer)
    }
}