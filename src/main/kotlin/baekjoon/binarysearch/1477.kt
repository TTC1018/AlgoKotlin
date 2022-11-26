package baekjoon.binarysearch

// 가장 긴 구간을 반으로 나누는 풀이법 -> 오답
// {200, 700, 800}에 휴게소가 있고, 2개를 더 세울 수 있는 예시라고 하면,
// 반으로 나누는 방식을 적용했을 때, 맨 처음 450에 짓고 325에 짓는다. 그럼 오답이다.
// 대신에 답이 될 수 있을 것 같은 값들을 모두 탐색해보는 수밖에 없다.
class `1477` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, M, L) = readLine().trim().split(" ").map { it.toInt() }
        val services = mutableListOf(0, L).apply {
            if (N != 0)
                addAll(readLine().trim().split(" ").map { it.toInt() })
        }

        services.sort()
        var start = 1
        var end = L
        var answer = 0

        while (start <= end) {
            val mid = (start + end) / 2

            var count = 0
            for (i in 1 until services.size) {
                val distance = services[i] - services[i - 1]
                count += (distance / mid)
                if (distance % mid == 0) // 나누어 떨어지면 count-1개만 있으면 됨
                    count--
            }

            if (count <= M) {
                end = mid - 1
                answer = mid
            } else {
                start = mid + 1
            }
        }

        print(answer)
    }
}

fun main() {

    `1477`().solution()

}