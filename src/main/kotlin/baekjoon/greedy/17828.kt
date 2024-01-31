package baekjoon.greedy

class `17828` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, X) = readLine().split(" ").map(String::toInt)
        // 다 확인하기는 불가능
        // Z로 쪼개고 남은 것은 A와 그 다음 알파벳으로 채우기?
        // 6 157 안 되는 이유 -> Z 6개 써도 나머지 있음
        val idxMap = buildMap<Int, Char> {
            (1..26).forEach { put(it, 'A' + it - 1) }
        }
        val zCnt = X.div(26)
        val rest = X.mod(26)
        if ((zCnt >= N && rest > 0) || N > X) {
            print('!')
        } else {
            val sb = StringBuilder()

            var leftN = N
            var leftVal = X
            while (leftVal > 0) {
                if (leftVal - 26 >= leftN) {
                    leftN--
                    leftVal -= 26
                    sb.append('Z')
                } else {
                    sb.append("${idxMap[leftVal - leftN + 1]!!}")
                    if (leftN - 1 > 0)
                        sb.append("A".repeat(leftN - 1))
                    break
                }
            }

            print(sb.reverse())
        }
    }
}