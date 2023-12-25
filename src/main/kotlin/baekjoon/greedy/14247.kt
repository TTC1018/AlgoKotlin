package baekjoon.greedy

class `14247` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val H = readLine().split(" ").map(String::toLong)
        val A = readLine().split(" ").map(String::toLong)
        // 성장 가능성이 높을 수록 뒤에 잘라야 이득임 (계속 자르는 거랑 며칠 뒤에 자르는 거랑 동일하기 때문)
        // 즉, 성장 가능성을 기준으로 정렬하고 더하면 됨
        print(H.sumOf { it } + A.sorted().mapIndexed { i, v -> i * v }.sumOf { it })
    }
}