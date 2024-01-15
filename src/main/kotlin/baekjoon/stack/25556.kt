package baekjoon.stack

class `25556` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val A = readLine().split(" ").map(String::toInt)
        val S = List(4) { mutableListOf(-1) }
        // 꺼낼 때 오름차순이려면 오름차순으로 쌓아야됨
        // 쌓다가 불가능하면 끝
        loop@for (a in A) {
            for (i in 0 until 4) {
                if (S[i].last() < a) {
                    S[i].add(a)
                    continue@loop
                }
            }

            print("NO")
            return
        }
        print("YES")
    }
}