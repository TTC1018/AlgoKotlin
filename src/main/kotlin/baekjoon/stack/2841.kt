package baekjoon.stack

class `2841` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, P) = readLine().split(" ").map(String::toInt)
        // 줄 튕기는 건 세지 않음
        // 프렛 떼기와 유지가 반복됨
        val stack = List(N) { mutableListOf<Int>() }
        var answer = 0
        repeat(N) {
            val (s, p) = readLine().split(" ").map(String::toInt)
            while (stack[s].isNotEmpty() && stack[s].last() > p) {
                stack[s].removeLast()
                answer++
            }

            if (stack[s].lastOrNull() != p) {
                stack[s].add(p)
                answer++
            }
        }
        print(answer)
    }
}