package baekjoon.bitmasking

class `1322` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (X, K) = readLine().split(" ").map(String::toLong)
        // X에 0비트가 있다면 -> 그거 채우는 숫자가 필요
        val kLen = K.toString(2).length
        var answer = 0L
        var i = 0
        var kPtr = 0
        while (true) {
            val bit = (X shr i) and 1L
            if (bit == 0L) {
                answer = answer or (((K shr kPtr) and 1) shl i)
                kPtr++
                if (kPtr == kLen)
                    break
            }
            i++
        }
        print(answer)
    }
}