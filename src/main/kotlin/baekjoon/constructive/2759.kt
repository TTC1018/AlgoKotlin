package baekjoon.constructive

class `2759` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            val ip = readLine().split(" ").map(String::toInt)
            var N = ip.first()
            val P = ip.drop(1).toIntArray()
            val T = P.sortedArray()
            val answer = mutableListOf<Int>()
            while (N > 1 && P.contentEquals(T).not()) {
                if (P.first() != N) {
                    val l = P.indexOf(N)
                    answer.add(l + 1) // 앞으로 가져오기
                    P.reverse(0, l + 1)
                }

                answer.add(N) // N번째로 보내기
                P.reverse(0, N)
                N--
            }
            sb.appendLine("${answer.size} ${answer.joinToString(" ")}")
        }
        print(sb.dropLast(1))
    }
}