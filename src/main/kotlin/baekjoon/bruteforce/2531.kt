package baekjoon.bruteforce
import kotlin.math.max

class `2531` {

    private var N = 2
    private var d = 2 // 초밥 가지수
    private var k = 2 // 연속 접시
    private var c = 1 // 쿠폰
    private val ate = mutableSetOf<Int>()
    private lateinit var belt: IntArray
    private var answer = 0

    private fun total(){
        ate.add(c)
        answer = max(answer, ate.size)
        return
    }

    fun solution() = with(System.`in`.bufferedReader()){

        readLine().split(" ").map { it.toInt() }
            .also {
                N = it[0]
                d = it[1]
                k = it[2]
                c = it[3]
            }

        val cycle = IntArray(N) { readLine().toInt() }
        belt = cycle + cycle.slice(0 until k)
        for (i in 0 until N){
            for (j in i until i+k){
                ate.add(belt[j])
            }
            total()
            ate.clear()
        }
        print(answer)
    }

}

fun main() {

    `2531`().solution()

}