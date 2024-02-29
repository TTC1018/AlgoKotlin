package baekjoon.implementation

class `1411` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val S = List(N) {
            readLine().let { S ->
                val charMap = mutableMapOf<Char, Int>()
                var num = 0
                val sToNum = IntArray(S.length).apply {
                    for (i in S.indices) {
                        charMap[S[i]]?.let {
                            this[i] = it
                        } ?: run {
                            this[i] = num
                            charMap[S[i]] = num++
                        }
                    }
                }
                sToNum
            }
        }

        var answer = 0
        for (i in 0 until N) {
            for (j in i + 1 until N) {
                if (S[i].contentEquals(S[j]))
                    answer++
            }
        }
        print(answer)
    }
}