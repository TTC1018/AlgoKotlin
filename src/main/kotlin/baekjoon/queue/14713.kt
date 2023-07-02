package baekjoon.queue

class `14713` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val q = Array(n) { ArrayDeque<String>().apply { addAll(readLine().split(" ")) } }
        val T = readLine().split(" ")

        for (t in T) {
            var pFlag = false
            for (i in 0 until n) {
                if (q[i].isNotEmpty() && q[i].first() == t) {
                    q[i].removeFirst()
                    pFlag = true
                    break
                }
            }

            if (pFlag.not()) {
                print("Impossible")
                return
            }
        }

        if (q.all { it.isEmpty() })
            print("Possible")
        else
            print("Impossible")
    }
}

fun main() { `14713`().solution() }