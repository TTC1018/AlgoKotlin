package baekjoon.priorityqueue

import java.util.PriorityQueue

class `1655` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val pqDown = PriorityQueue<Int>(reverseOrder()) // 중간값 이하 숫자를 넣는 곳
        val pqUp = PriorityQueue<Int>() // 중간값 초과 숫자를 넣는 곳
        val answer = StringBuilder()

        repeat(N) {
            val now = readLine().toInt()
            if (pqDown.size == pqUp.size) // pqDown을 기준으로 숫자를 추가한다.
                pqDown.add(now)
            else // 서로 개수가 안 맞으면 pqUp에 넣기
                pqUp.add(now)

            if (pqUp.isNotEmpty() && pqDown.peek() > pqUp.peek()){ // 중간값이 pqUp에 들어간 경우
                val smaller = pqUp.remove()
                val bigger = pqDown.remove()

                // Swap
                pqDown.add(smaller)
                pqUp.add(bigger)
            }

            answer.append("${pqDown.peek()}\n")
        }

        print(answer)
    }

}

fun main() {

    `1655`().solution()

}