package baekjoon.greedy

class `24524` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val S = readLine()
        val T = readLine()
        val tIdx = buildMap { T.forEachIndexed { index, c -> put(c, index) } }
        val checked = IntArray(T.length) { 0 }

        for (s in S) {
            if (s in tIdx) {
                val idx = tIdx[s] ?: -1
                if (idx == 0) {
                    checked[idx]++ // 첫번째 문자는 그냥 카운트
                } else if (idx > 0) {
                    if (checked[idx - 1] > 0) { // 이전 문자가 준비되어 있다면
                        checked[idx - 1]-- // 지우고
                        checked[idx]++ // 다음 문자 개수 카운트
                    }
                }
            }
        }
        print(checked.last()) // 마지막 문자 카운트 = 완성된 문자열의 개수
    }
}

fun main() {
    `24524`().solution()
}