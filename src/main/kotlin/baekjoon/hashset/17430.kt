package baekjoon.hashset

class `17430` {
    fun solution() = with(System.`in`.bufferedReader()) {
        for (t in 0 until readLine().toInt()) {
            val N = readLine().toInt()
            val x = mutableSetOf<Long>()
            val y = mutableSetOf<Long>()
            repeat(N) {
                readLine().split(" ").map(String::toLong).run {
                    x.add(first()); y.add(last())
                }
            }

            if (x.size * y.size == N) {
                println("BALANCED")
            } else {
                println("NOT BALANCED")
            }
        }
    }
}