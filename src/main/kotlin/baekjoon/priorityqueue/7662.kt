package baekjoon.priorityqueue

import java.util.*

class `7662` {
    private data class IdxAndNum(
        val idx: Int,
        val num: Int,
    ): Comparable<IdxAndNum> {
        override fun compareTo(other: IdxAndNum): Int {
            return when {
                num > other.num -> 1
                num == other.num -> 0
                else -> -1
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        val leftQ = PriorityQueue<IdxAndNum>()
        val rightQ = PriorityQueue<IdxAndNum>(reverseOrder())
        for (t in 0 until readLine().toInt()) {
            val k = readLine().toInt()
            val pushed = BooleanArray(k) { false }
            leftQ.clear()
            rightQ.clear()
            for (i in 0 until k) {
                val opAndNum = readLine().split(" ")
                val op = opAndNum.first()
                val num = opAndNum.last().toInt()
                when (op) {
                    "I" -> {
                        leftQ.add(IdxAndNum(i, num))
                        rightQ.add(IdxAndNum(i, num))
                        pushed[i] = true
                    }

                    "D" -> {
                        when (num) {
                            1 -> {
                                // 제거 대상 out
                                while (rightQ.isNotEmpty() && pushed[rightQ.first().idx].not()) {
                                    rightQ.remove()
                                }

                                // 하나 제거
                                if (rightQ.isNotEmpty()) {
                                    pushed[rightQ.first().idx] = false
                                    rightQ.remove()
                                }
                            }

                            -1 -> {
                                while (leftQ.isNotEmpty() && pushed[leftQ.first().idx].not()) {
                                    leftQ.remove()
                                }

                                if (leftQ.isNotEmpty()) {
                                    pushed[leftQ.first().idx] = false
                                    leftQ.remove()
                                }
                            }
                        }
                    }
                }
            }

            // 제거 대상 out
            while (leftQ.isNotEmpty() && pushed[leftQ.first().idx].not()) {
                leftQ.remove()
            }
            while (rightQ.isNotEmpty() && pushed[rightQ.first().idx].not()) {
                rightQ.remove()
            }

            if (leftQ.isEmpty() || rightQ.isEmpty()) {
                sb.append("EMPTY\n")
            } else {
                sb.append("${rightQ.first().num} ${leftQ.first().num}\n")
            }
        }
        print(sb.deleteAt(sb.length - 1).toString())
    }
}