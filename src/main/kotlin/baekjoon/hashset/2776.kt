package baekjoon.hashset

class `2776` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val T = readLine().trim().toInt()
        repeat(T) {

            val N = readLine().trim().toInt()
            val noteOne = readLine().trim().split(" ").map { it.toInt() }.toSet()
            val M = readLine().trim().toInt()
            val noteTwo = readLine().trim().split(" ").map { it.toInt() }

            val answer = mutableListOf<Int>()
            for (num in noteTwo){
                when(noteOne.contains(num)) {
                    true -> answer.add(1)
                    false -> answer.add(0)
                }
            }

            println(answer.joinToString("\n"))
        }
    }

}

fun main() {

    `2776`().solution()

}