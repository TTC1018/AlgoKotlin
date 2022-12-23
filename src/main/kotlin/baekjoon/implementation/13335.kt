package baekjoon.implementation

class `13335` {

    data class TruckInfo(
        val weight:Int,
        val came:Int
    )

    fun solution() = with(System.`in`.bufferedReader()) {

        val (n, w, L) = readLine().split(" ").map { it.toInt() }
        val a = readLine().split(" ").map { it.toInt() }
        val ongoing = ArrayDeque<TruckInfo>()

        var time = 0
        var nowL = 0
        var nowIdx = 0
        var count = 0
        while (count < n){

            repeat(ongoing.size) {
                if (ongoing.isNotEmpty()){
                    val (weight, came) = ongoing.removeFirst()
                    if (came + 1 != w)
                        ongoing.add(TruckInfo(weight, came + 1))
                    else{
                        nowL -= weight
                        count++
                    }
                }
            }

            if (nowIdx < n && nowL + a[nowIdx] <= L){
                ongoing.add(TruckInfo(a[nowIdx], 0))
                nowL += a[nowIdx]
                nowIdx++
            }

            time++
        }

        print(time)
    }

}

fun main() {

    `13335`().solution()

}