package baekjoon.gametheory

class `9659` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toLong()
        // 케이스를 적다보면 아래 해답이 나옴
        if (N % 2 == 1L){
            print("SK")
        } else {
            print("CY")
        }
    }
}