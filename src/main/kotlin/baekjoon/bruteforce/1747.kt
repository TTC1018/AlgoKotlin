package baekjoon.bruteforce

import kotlin.math.sqrt

class `1747` {

    private var N = 0
    private var answer = 0

    private fun isPrime(num: Int):Boolean{
        if (num == 1)
            return false
        else if (num == 2)
            return true

        for (i in 2..sqrt(num.toDouble()).toInt()+1){
            if (num % i == 0)
                return false
        }
        return true
    }

    private fun findPalindrome(){

        var now = N
        while (true) {
            if (now.toString() == now.toString().reversed()){
                if (isPrime(now)) {
                    answer = now
                    return
                }
            }
            now++
        }
    }

    fun solution() = with(System.`in`.bufferedReader()){

        N = readLine().toInt()
        findPalindrome()
        print(answer)
    }

}

fun main() {

    `1747`().solution()

}