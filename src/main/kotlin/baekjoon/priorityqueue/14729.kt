package baekjoon.priorityqueue

import java.util.PriorityQueue

class `14729` {

    fun solution():String = with(System.`in`.bufferedReader()){
        val N = readLine().toInt()
        val answer = PriorityQueue<Double>(reverseOrder())

        (1..7).forEach {
            val num = readLine().toDouble()
            answer.add(num)
        }

        (8..N).forEach {
            val num = readLine().toDouble()
            answer.add(num)
            answer.remove()
        }

        return answer
            .sorted()
            .map { String.format("%.3f", it) }
            .joinToString("\n")
    }
}


fun main(){
    print(`14729`().solution())
}