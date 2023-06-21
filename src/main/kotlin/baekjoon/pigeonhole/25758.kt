package baekjoon.pigeonhole

class `25758` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val G = readLine().split(" ")

        // 앞 - 뒤가 같은 조합은 무조건 같은 답을 냄
        // 사전 순으로 뒤에 오는 것만 표현됨
        // 다 카운트하고, 본인 이하 알파벳이 하나라도 존재하면 표현형이 됨
        val firstMap = buildMap {
            ('A'..'Z').forEach { put(it, 0) }
        }.toMutableMap()
        val secMap = buildMap {
            ('A'..'Z').forEach { put(it, 0) }
        }.toMutableMap()

        for (g in G) {
            firstMap[g[0]] = firstMap[g[0]]!! + 1
            secMap[g[1]] = secMap[g[1]]!! + 1
        }

        val answer = mutableSetOf<Char>()
        for (g in G) {
            val f = g[0]; val s = g[1]
            for ((k, v) in firstMap) {
                if (k <= s && v > 0) {
                    when {
                        f != k -> answer.add(s)
                        f == k && v > 1 -> answer.add(s)
                    }
                }
            }
            for ((k, v) in secMap) {
                if (k <= f && v > 0) {
                    when {
                        s != k -> answer.add(f)
                        s == k && v > 1 -> answer.add(f)
                    }
                }
            }
        }

        println(answer.size)
        print(answer.sorted().joinToString(" "))
    }

}

fun main() {

    `25758`().solution()

}