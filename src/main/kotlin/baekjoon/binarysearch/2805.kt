package baekjoon.binarysearch

class `2805` {

    fun solution():Long = with(System.`in`.bufferedReader()) {

        val (N, M) = readLine().split(" ").map { it.toInt() }
        val T = readLine().split(" ").map { it.toLong() }

        var start = 1L
        var end = T.maxOf { it }
        var answer = 0L
        while (start <= end){
            val mid = (start + end) / 2L

            val cut = T.sumOf { it - mid }
            if (cut < M){
                end = mid - 1
            }
            else {
                answer = mid
                start = mid + 1
            }
        }

        return answer
    }

}

fun main() {

    println(`2805`().solution())

}