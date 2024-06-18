package baekjoon.bitmasking

class `12025` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val P = readLine().toCharArray()
        val k = readLine().toLong() - 1
        val T = "1627".toSet()
        val onlyP = P.withIndex().filter { it.value in T }.reversed()
        when {
            onlyP.isEmpty() && k == 0L -> print(P)
            onlyP.size < k.toString(2).length -> print(-1)
            else -> {
                val answer = k.toString(2).reversed().padEnd(onlyP.size, '0')
                for (i in answer.indices) {
                    P[onlyP[i].index] = when (answer[i]) {
                        '0' -> {
                            when (onlyP[i].value) {
                                '1', '6' -> '1'
                                else -> '2'
                            }
                        }
                        else -> {
                            when (onlyP[i].value) {
                                '1', '6' -> '6'
                                else -> '7'
                            }
                        }
                    }
                }
                print(P.joinToString(""))
            }
        }
    }
}