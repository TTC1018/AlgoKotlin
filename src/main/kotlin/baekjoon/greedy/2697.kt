package baekjoon.greedy

class `2697` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val answer = mutableListOf<String>()
        loop@ for (t in 0 until readLine().toInt()) {
            val num = readLine().toCharArray()

            for (i in num.size - 2 downTo 0) {
                if (num[i] < num[i + 1]) { // 순서가 달라질 수 있는 지점
                    var cIdx = i+1
                    var minDiff = Int.MAX_VALUE
                    // num[i]와 가장 가까운 수 탐색
                    for (j in i+1 until num.size) {
                        val diff = num[j] - num[i]
                        if (num[j] > num[i] && diff < minDiff) {
                            minDiff = diff
                            cIdx = j
                        }
                    }

                    // 스왑
                    val p1 = num[i]
                    num[i] = num[cIdx]
                    num[cIdx] = p1

                    // 사전 순 가장 앞서는 문자열로 재정렬
                    answer.add(
                        (num.slice(0 .. i) +
                                num.slice(i+1 until num.size).sorted())
                            .joinToString("")
                    )
                    continue@loop
                }
            }

            answer.add("BIGGEST")
        }
        print(answer.joinToString("\n"))
    }
}