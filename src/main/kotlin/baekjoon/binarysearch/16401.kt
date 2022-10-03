package baekjoon.binarysearch

class `16401` {

    fun solution():Int = with(System.`in`.bufferedReader()){
        val (M, N) = readLine().split(" ").map { it.toInt() }
        val L = readLine().split(" ").map { it.toInt() }

        var answer = 0
        var left = 1
        var right = L.maxOf { it }

        while (left <= right){
            val mid = (left + right) / 2
            var cnt = 0

            for (snack in L){
                if (mid <= snack)
                    cnt += (snack / mid)
            }

            if (cnt >= M){
                answer = mid
                left = mid + 1
            }
            else{
                right = mid - 1
            }
        }

        return answer
    }

}


fun main(){
    print(`16401`().solution())
}