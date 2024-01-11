package baekjoon.greedy

import java.util.*
import kotlin.math.absoluteValue

class `2831` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        // 양수 -> 자신보다 키 커야됨 / 음수 -> 자신보다 키 작아야됨
        // 절대값 작은 양수 - 절대값 큰 음수 조합이 이루어져야 함
        // 만들 수 있는 쌍의 최대값
        // 자신과 최대한 가까운 절대값
        val mm = PriorityQueue<Int>(reverseOrder())
        val pm = PriorityQueue<Int>(reverseOrder())
        val mw = PriorityQueue<Int>(reverseOrder())
        val pw = PriorityQueue<Int>(reverseOrder())
        readLine().split(" ").map(String::toInt).partition { it < 0 }.run {
            mm.addAll(first.map { it.absoluteValue })
            pm.addAll(second)
        }
        readLine().split(" ").map(String::toInt).partition { it < 0 }.run {
            mw.addAll(first.map { it.absoluteValue })
            pw.addAll(second)
        }

        var answer = 0
        while (pm.isNotEmpty() && mw.isNotEmpty()) {
            val plusMan = pm.remove()
            val minusWoman = mw.remove()

            if (plusMan >= minusWoman) {
                mw.add(minusWoman)
            } else {
                answer++
            }
        }
        while (pw.isNotEmpty() && mm.isNotEmpty()) {
            val plusWoman = pw.remove()
            val minusMan = mm.remove()

            if (plusWoman >= minusMan) {
                mm.add(minusMan)
            } else {
                answer++
            }
        }
        print(answer)
    }
}