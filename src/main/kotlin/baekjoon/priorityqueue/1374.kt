package baekjoon.priorityqueue

import java.util.PriorityQueue

class `1374` {

    data class ClassInfo(
        val num:Int,
        val start:Int,
        val end:Int
    ):Comparable<ClassInfo>{

        override fun compareTo(other: ClassInfo):Int =
            this.end - other.end

    }

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val room = PriorityQueue<ClassInfo>()
        val classes = mutableListOf<ClassInfo>().apply {
            repeat(N) {
                val (num, start, end) = readLine().split(" ").map { it.toInt() }
                add(ClassInfo(num, start, end))
            }
        }

        classes.sortBy { it.start }
        room.add(classes.first())

        var answer = 1
        for (i in 1 until N){
            if (classes[i].start < room.peek().end){
                room.add(classes[i])
                answer++
            }
            else{
                room.remove()
                room.add(classes[i])
            }
        }
        println(answer)
    }

}

fun main() {

    `1374`().solution()

}