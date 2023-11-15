package baekjoon.bruteforce

class `17359` {
    private var N = 0
    private lateinit var S: List<String>
    private var answer = 0
    private var tempAnswer = Int.MAX_VALUE
    private val nums = mutableListOf<String>()
    private lateinit var visited: BooleanArray

    private fun bruteforce(total: Int) {
        if (nums.size == N) {
            tempAnswer = minOf(tempAnswer, total)
            return
        }

        for (i in 0 until N) {
            if (visited[i].not()) {
                visited[i] = true
                nums.lastOrNull()?.let {
                    nums.add(S[i])
                    bruteforce(if (it.last() != S[i].first()) total + 1 else total)
                    nums.removeLast()
                } ?: run {
                    nums.add(S[i])
                    bruteforce(total)
                    nums.removeLast()
                }
                visited[i] = false
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        // 내부의 전구 상태 변화 개수는 고정임
        // 시작과 끝이 만났을 때 변화만 세자
        visited = BooleanArray(N) { false }
        S = List(N) {
            val nums = readLine()
            nums.zipWithNext { p, n -> if (p != n) answer++ }

            if (nums.length == 1)
                nums.first().toString()
            else
                "${nums.first()}${nums.last()}"
        }

        bruteforce(0)
        print(answer + tempAnswer)
    }
}