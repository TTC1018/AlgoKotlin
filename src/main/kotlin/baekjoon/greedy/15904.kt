package baekjoon.greedy

class `15904` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val s = readLine().trim().filter { it.isUpperCase() }
        val target = "UCPC"
        var sIdx = 0

        for (a in s){
            if (a == target[sIdx])
                sIdx++

            if (sIdx == target.length)
                break
        }

        if (sIdx == target.length)
            println("I love UCPC")
        else
            println("I hate UCPC")
    }

}

fun main() {

    `15904`().solution()

}