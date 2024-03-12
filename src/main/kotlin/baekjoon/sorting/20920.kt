package baekjoon.sorting

class `20920` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val counter = mutableMapOf<String, Int>()
        val S = buildSet {
            repeat(N) {
                val input = readLine()
                if (input.length >= M) {
                    add(input)
                    counter[input] = counter.getOrDefault(input, 0) + 1
                }
            }
        }
        print(
            S.sortedWith(object : Comparator<String> {
                override fun compare(o1: String?, o2: String?): Int {
                    if (counter[o1]!! != counter[o2]!!)
                        return counter[o2]!!.compareTo(counter[o1]!!)

                    if (o1!!.length != o2!!.length)
                        return o2.length.compareTo(o1.length)

                    return o1.compareTo(o2)
                }
            }).joinToString("\n")
        )
    }
}