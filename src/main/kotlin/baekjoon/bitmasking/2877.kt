package baekjoon.bitmasking

class `2877` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val K = readLine().toInt()
        print((K + 1).toString(2).drop(1).map { if (it == '0') '4' else '7' }.joinToString(""))
    }
}