package baekjoon.bruteforce

class `15664` {
    private var N = 0
    private var M = 0
    private lateinit var A: List<Int>
    private lateinit var visited: BooleanArray
    private var answer = mutableSetOf<String>()
    private val nums = mutableListOf<Int>()

    private fun bruteforce(cnt: Int) {
        if (cnt == M) {
            answer.add(nums.joinToString(" "))
            return
        }

        for (i in 0 until N) {
            if (visited[i].not()) {
                visited[i] = true
                nums.lastOrNull()?.let {
                    if (it <= A[i]) {
                        nums.add(A[i])
                        bruteforce(cnt + 1)
                        nums.removeLast()
                    }
                } ?: run {
                    nums.add(A[i])
                    bruteforce(cnt + 1)
                    nums.removeLast()
                }
                visited[i] = false
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); M = last()
        }
        A = readLine().split(" ").map(String::toInt).sorted()
        visited = BooleanArray(N) { false }

        bruteforce(0)
        print(answer.joinToString("\n"))
    }
}