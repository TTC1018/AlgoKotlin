package baekjoon.string

class `3107` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val ipv6 = readLine().split(":")
        val answer = mutableListOf<String>()

        var cnt = 0
        for (i in ipv6.indices) {
            when {
                ipv6[i].isNotEmpty() -> {
                    answer.add("0".repeat(4 - ipv6[i].length) + ipv6[i])
                    cnt++
                }
                else -> {
                    // 제일 뒤 공백의 다음 문자부터 count하는 숫자 개수
                    val rest = ipv6.size - ipv6.indexOfLast { it.isEmpty() } - 1
                    repeat(8 - rest - cnt) {
                        answer.add("0000")
                    }
                    cnt += (8 - rest - cnt)
                }
            }
        }

        print(answer.joinToString(":"))
    }

}


fun main() {

    `3107`().solution()

}