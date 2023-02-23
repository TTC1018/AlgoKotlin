package baekjoon.stack

class `6198` {

    private var N = 0
    private lateinit var building: IntArray

    fun solution() = with(System.`in`.bufferedReader()) {

        N = readLine().toInt()
        building = IntArray(N) { readLine().toInt() }

        // N^2 -> X
        // 볼 수 있는 영역 = 자신 높이 이상의 빌딩 이전까지
        // 현재 빌딩 높이 초과하는 값들을 누적해서 더하기

        var answer = 0L
        val stack = ArrayDeque<Int>().apply { add(building.first()) }

        for (i in 1 until N){
            while (stack.isNotEmpty() && stack.last() <= building[i])
                stack.removeLast()
            answer += stack.size
            stack.add(building[i])
        }

        print(answer)
    }

}

fun main() {

    `6198`().solution()

}