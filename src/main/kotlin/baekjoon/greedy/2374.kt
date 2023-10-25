package baekjoon.greedy

class `2374` {
    // Add 사용시 해당 숫자 좌우로 연결된 같은 수들이 함께 증가함
// 모든 수가 같아질 때까지 Add 연산
// 연결된 같은 수 -> 하나로 합친다고 생각?
    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val A = mutableListOf<Long>().apply {
            repeat(n) {
                val num = readLine().toLong()
                lastOrNull()?.run {
                    if (this != num)
                        add(num)
                } ?: add(num)
            }
        }

        var answer = 0L
        val visited = BooleanArray(A.size) { false }
        for (i in A.indices) {
            // 좌-우 중에서 덜 작은 수만큼 증가시킨다
            if (visited[i].not()) {
                visited[i] = true
                var closest = Long.MAX_VALUE
                for (l in i - 1 downTo 0) {
                    if (A[l] == A[i]) {
                        visited[l] = true
                    } else if (A[l] > A[i]) {
                        closest = minOf(closest, A[l])
                        break
                    }
                }
                for (r in i + 1 until A.size) {
                    if (A[r] == A[i]) {
                        visited[r] = true
                    } else if (A[r] > A[i]) {
                        closest = minOf(closest, A[r])
                        break
                    }
                }

                if (closest != Long.MAX_VALUE)
                    answer += (closest - A[i])
            }
        }
        print(answer)
    }

// 5
// 3 1 2 1 4 -> 4
// 2 1 1 2 3 -> 2
// 4 2 1 2 3 -> 3
}