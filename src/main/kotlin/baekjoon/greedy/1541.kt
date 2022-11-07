package baekjoon.greedy

class `1541` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val formula = readLine()
            .split("-") // -가 가장 오래 연장되도록 -를 기준으로 split
            .map { f -> f.split("+")
                .sumOf { it.toInt() }
            } // split된 숫자들을 합치기

        val answer = formula.reduce { total, sum -> total - sum }
        println(answer)
    }

}

fun main() {

    `1541`().solution()

}