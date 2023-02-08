package baekjoon.graph

class `2617` {

    private var N = 0
    private var M = 0
    private lateinit var lt: IntArray
    private lateinit var gt: IntArray
    private lateinit var lVisited: BooleanArray
    private lateinit var gVisited: BooleanArray
    private lateinit var lessThan: Array<MutableSet<Int>>
    private lateinit var greaterThan: Array<MutableSet<Int>>

    private fun searchUpper(start:Int, now: Int){
        gVisited[now] = true

        for (nxt in greaterThan[now]){
            if (gVisited[nxt].not()){
                gt[start]++
                searchUpper(start, nxt)
            }
        }
    }

    private fun searchLower(start:Int, now: Int){
        lVisited[now] = true

        for (nxt in lessThan[now]){
            if (lVisited[nxt].not()){
                lt[start]++
                searchLower(start, nxt)
            }
        }
    }


    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map { it.toInt() }.also { N = it.first(); M = it.last() }
        lt = IntArray(N) { 0 }
        gt = IntArray(N) { 0 }
        lessThan = Array(N) { mutableSetOf() }
        greaterThan = Array(N) { mutableSetOf() }

        repeat(M) {
            val (A, B) = readLine().split(" ").map { it.toInt() - 1 }
            greaterThan[B].add(A)
            lessThan[A].add(B)
        }

        for (i in 0 until N){
            lVisited = BooleanArray(N) { false }
            gVisited = BooleanArray(N) { false }
            searchUpper(i, i)
            searchLower(i, i)
        }

        var answer = 0
        for (i in 0 until N){
            if (lt[i] > N / 2 || gt[i] > N / 2)
                answer++
        }
        println(answer)
    }

}

fun main() {

    `2617`().solution()

}