package baekjoon.bruteforce

import kotlin.math.max


class `17281` {

    private var N = 0
    private lateinit var inning: Array<IntArray>
    private lateinit var checked: BooleanArray
    private var order = mutableListOf<Int>()
    private var answer = 0

    private fun bruteforce(){
        if (order.size == 9){
            answer = max(answer, calcScore())
            return
        }

        if (order.size == 3){ // 4번째 타자는 1번 선수로 고정
            order.add(1)
            bruteforce()
            order.removeLast()
            return
        }

        for (i in 1..9){
            if (checked[i].not()){
                checked[i] = true
                order.add(i)
                bruteforce()
                order.removeLast()
                checked[i] = false
            }
        }
    }

    private fun calcScore(): Int{
        var result = 0
        var idx = 0
        for (inn in inning){
            var out = 0
            val base = BooleanArray(3) { false }
            while (out < 3){
                when (inn[order[idx] - 1]){
                    0 -> out++
                    1 -> {
                        if (base[2]) result++
                        base[2] = base[1]
                        base[1] = base[0]
                        base[0] = true
                    }
                    2 -> {
                        if (base[2]) result++
                        if (base[1]) result++
                        base[2] = base[0]
                        base[1] = true
                        base[0] = false
                    }
                    3 -> {
                        result += base.count { it }
                        base[2] = true
                        base[1] = false
                        base[0] = false
                    }
                    4 -> {
                        result += base.count { it } + 1
                        base[2] = false
                        base[1] = false
                        base[0] = false
                    }
                }
                idx = (idx + 1) % 9
            }
        }

        return result
    }

    fun solution() = with(System.`in`.bufferedReader()){

        N = readLine().toInt()
        inning = Array(N) { readLine().split(" ").map { it.toInt() }.toIntArray() }
        checked = BooleanArray(9 + 1) { false }.also { it[1] = true }

        bruteforce()

        print(answer)
    }

}

fun main(){

    `17281`().solution()

}