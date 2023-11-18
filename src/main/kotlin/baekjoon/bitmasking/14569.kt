package baekjoon.bitmasking

class `14569` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val T = List(N) { readLine().split(" ").map(String::toInt).drop(1) }
            .map {
                var bit = 0L
                for (n in it)
                    bit = bit or (1L shl n)
                bit
            }
        val M = readLine().toInt()
        val Q = List(M) { readLine().split(" ").map(String::toInt).drop(1) }
            .map {
                var bit = 0L
                for (n in it)
                    bit = bit or (1L shl n)
                bit
            }

        print(Q.map { q -> T.count { q and it == it } }.joinToString("\n"))
    }
}