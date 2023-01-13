package baekjoon.binarysearch

class `3020` {

    private var N = 0
    private var H = 0

    // lower bound
    fun bSearch(l: List<Int>, t:Float, start:Int, end:Int) : Int{

        var left = start
        var right = end

        while (left <= right){
            val mid = (left + right) / 2

            if (l[mid] >= t)
                right = mid - 1
            else
                left = mid + 1
        }

        return end - left + 1
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map { it.toInt() }.also {
            N = it.first()
            H = it.last()
        }
        val bot = mutableListOf<Int>()
        val top = mutableListOf<Int>()
        repeat(N) { idx ->
            val num = readLine().toInt()
            if (idx % 2 == 0)
                bot.add(num)
            else
                top.add(num)
        }
        bot.sort()
        top.sort()
        val bSize = bot.size
        val tSize = top.size

        var answerVal = Int.MAX_VALUE
        var answerCnt = 0
        for (height in 1..H){
            val target = height.toFloat()
            val a1 = bSearch(bot, target - 0.5f, 0, bSize - 1)
            val a2 = bSearch(top, H - (target - 0.5f), 0, tSize - 1)

            when {
                a1 + a2 == answerVal -> answerCnt++
                a1 + a2 < answerVal -> {
                    answerVal = a1 + a2
                    answerCnt = 1
                }
            }
        }

        println("$answerVal $answerCnt")
    }

}

fun main() {

    `3020`().solution()

}