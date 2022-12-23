package baekjoon.greedy

class `1461` {

    private fun calcDist(locs:List<Int>, start:Int, stepVal:Int):Int{
        var result = 0
        for (i in locs.size - 1 - start downTo 0 step stepVal){
            result += (locs[i] * 2)
        }
        return result
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, M) = readLine().split(" ").map { it.toInt() }
        val locs = readLine().split(" ").map { it.toInt() }
        val plusLocs = locs.filter { it > 0 }.sorted()
        val minusLocs = locs.filter { it < 0 }.map { -it }.sorted()

        var answer = 0
        when {
            locs.size == 1 -> {
                print(locs.first())
                return
            }
            plusLocs.isNotEmpty() && minusLocs.isNotEmpty() -> {
                if (plusLocs.last() >= minusLocs.last()) { // 양수 쪽 최대 거리가 더 멀다면
                    answer += plusLocs.last() // 양수 쪽 최대 거리 한번만 가기
                    answer += calcDist(plusLocs, M, M)
                    answer += calcDist(minusLocs, 0, M)
                } else {
                    answer += minusLocs.last() // 음수 쪽 최대 거리 한번만 가기
                    answer += calcDist(minusLocs, M, M)
                    answer += calcDist(plusLocs, 0, M)
                }
            }
            plusLocs.isEmpty() -> { // 음수만 있으면 음수쪽만 계산
                answer += minusLocs.last()
                answer += calcDist(minusLocs, M, M)
            }
            else -> {
                answer += plusLocs.last()
                answer += calcDist(plusLocs, M, M)
            }
        }

        print(answer)
    }

}

fun main() {

    `1461`().solution()

}