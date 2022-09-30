package kakao

import java.util.LinkedList
import java.util.Queue

class Solution118667 {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val q1:Queue<Int> = LinkedList(queue1.asList())
        val q2:Queue<Int> = LinkedList(queue2.asList())

        val limit = (q1.size + q2.size) * 2
        var q1Sum:Long = q1.sum().toLong()
        var q2Sum:Long = q2.sum().toLong()

        for ((count, _) in (0..limit).withIndex()) {
            when {
                q1Sum == q2Sum -> return count
                q1Sum > q2Sum -> {
                    val popLeft = q1.remove()
                    q1Sum -= popLeft
                    q2Sum += popLeft
                    q2.add(popLeft)
                }
                q1Sum < q2Sum -> { // ??
                    val popLeft = q2.remove()
                    q2Sum -= popLeft
                    q1Sum += popLeft
                    q1.add(popLeft)
                }
            }
        }

        return -1
    }
}


fun main(){
    println(Solution118667().solution(intArrayOf(3, 2, 7, 2), intArrayOf(4, 6, 5, 1)))
}