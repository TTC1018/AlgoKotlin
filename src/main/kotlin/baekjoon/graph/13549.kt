package baekjoon.graph

class `13549` {

    data class PosData(
        val now:Int,
        val count:Int
    )

    fun solution() = with(System.`in`.bufferedReader()){
        val (N, K) = readLine().split(" ").map { it.toInt() }
        val visited = Array(100000 + 1) { false }
        val q = ArrayDeque<PosData>().apply { add(PosData(N, 0)) }
        visited[N] = true

        while (q.isNotEmpty()){
            val (now, count) = q.removeFirst()
            if (now == K){
                println(count)
                break
            }

            if (now * 2 <= 100000 && visited[now * 2].not()){
                q.addFirst(PosData(now * 2, count))
                visited[now * 2] = true
            }
            if (now > 0 && visited[now - 1].not()) {
                q.addLast(PosData(now - 1, count + 1))
                visited[now - 1] = true
            }
            if (now < K && visited[now + 1].not()){
                q.addLast(PosData(now + 1, count + 1))
                visited[now + 1] = true
            }
        }

    }

}

fun main(){

    `13549`().solution()

}