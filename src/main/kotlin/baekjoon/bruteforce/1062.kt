package baekjoon.bruteforce

import kotlin.math.max

class `1062` {

    private var answer = 0
    private val cand = mutableSetOf<Char>()
    private val necessary = "antic".toCharArray().toSet()

    private fun bruteforce(idx:Int, cands:List<Char>, words:Array<Set<Char>>, end: Int){
        if (idx == cands.size || cand.size == end){
            answer = max(answer, words.count { cand.containsAll(it) })
            return
        }

        for (i in idx until cands.size){
            cand.add(cands[i])
            bruteforce(i + 1, cands, words, end)
            cand.remove(cands[i])
        }
    }

    fun solution() = with(System.`in`.bufferedReader()){

        val (N, K) = readLine().split(" ").map { it.toInt() }

        if (K < 5){
            print(0)
            return
        }
        else {
            val rest = K - 5
            val words = Array(N) { readLine().toSet().subtract(necessary) }
            val cands = mutableSetOf<Char>().apply { words.forEach { addAll(it) } }

            bruteforce(0, cands.toList(), words, rest)
            print(answer)
        }

    }

}

fun main() {

    `1062`().solution()

}