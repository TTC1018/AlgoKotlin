package baekjoon.string

import kotlin.math.sqrt
import kotlin.math.max


class `5636` {

    private val answers = mutableListOf<Int>()

    private fun isPrime(num: Int): Boolean{
        if (num == 2)
            return true

        for (i in 2..sqrt(num.toDouble()).toInt()+1){
            if (num % i == 0)
                return false
        }
        return true
    }

    fun solution() = with(System.`in`.bufferedReader()){

        while (true){

            var answer = -1
            val input = readLine()
            if (input == "0")
                break

            for (l in 1..6){
                for (start in 0 until input.length - l){
                    val sliced = input.slice(start until start+l).toInt()
                    if (sliced in 2..100000 && isPrime(sliced))
                        answer = max(answer, sliced)
                }
            }
            answers.add(answer)

        }
        print(answers.joinToString("\n"))
    }

}

fun main() {

    `5636`().solution()

}