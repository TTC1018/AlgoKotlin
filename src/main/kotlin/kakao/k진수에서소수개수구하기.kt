package kakao

import kotlin.math.sqrt

class Solution92335 {
    fun solution(n: Int, k: Int): Int{
        val kNumStr = toKNumber(n, k)
        val splited = kNumStr.split("0")

        return splited.count { it.isNotEmpty() && isPrime(it.toLong()) }
    }

    private fun toKNumber(num:Int, k: Int):String{
        var number = num
        val kNum = StringBuilder()
        while (number > 0){
            kNum.append(number.rem(k))
            number /= k
        }
        return kNum.toString().reversed()
    }

    private fun isPrime(num:Long):Boolean{
        for (n in 2..sqrt(num.toDouble()).toInt()){
            if (num.rem(n) == 0L)
                return false
        }
        return num != 1L
    }
}

fun main(){
    print(Solution92335().solution(1000000, 3))
}