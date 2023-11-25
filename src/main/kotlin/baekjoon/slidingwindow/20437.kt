package baekjoon.slidingwindow

class `20437` {
    fun solution() = with(System.`in`.bufferedReader()) {
        print(
            buildList {
                repeat(readLine().toInt()) {
                    val W = readLine()
                    val K = readLine().toInt()

                    val counter = buildMap<Char, MutableList<Int>> {
                        W.forEachIndexed { i, c -> getOrPut(c) { mutableListOf() }.add(i) }
                    }
                    val cands = counter.filterValues { it.size >= K }
                    if (cands.isEmpty()) {
                        add(-1)
                    } else {
                        var (short, long) = Int.MAX_VALUE to Int.MIN_VALUE
                        for (idxes in cands.values) {
                            // K개 포함하는 길이 순차적으로 확인
                            for (i in 0..idxes.size - K) {
                                val l = idxes[i + K - 1] - idxes[i] + 1
                                short = minOf(short, l)
                                long = maxOf(long, l)
                            }
                        }
                        add("$short $long")
                    }
                }
            }.joinToString("\n")
        )
    }
}