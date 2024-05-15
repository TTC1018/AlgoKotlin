package baekjoon.math

class `21980` {
    private data class Info(
        val flat: String,
        val uCounter: Int,
    ): Comparable<Info> {
        override fun compareTo(other: Info): Int {
            if (flat != other.flat)
                return flat.compareTo(other.flat)
            return uCounter.compareTo(other.uCounter)
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            val (n, k) = readLine().split(' ').map(String::toInt)
            val x = readLine().split(" ").map {
                Info(
                    flat = it.map { c -> c.lowercase() }.sorted().joinToString(""),
                    uCounter = it.count { c -> c.isUpperCase() },
                )
            }.sorted()
            var answer = 0L
            var prevIdx = 0
            for (i in x.indices) {
                if (x[prevIdx] != x[i]) {
                    val len = i - prevIdx
                    answer += (len * (len - 1)) / 2
                    prevIdx = i
                }
            }

            val last = n - prevIdx
            answer += (last * (last - 1)) / 2
            sb.appendLine(answer)
        }
        print(sb.dropLast(1))
    }
}