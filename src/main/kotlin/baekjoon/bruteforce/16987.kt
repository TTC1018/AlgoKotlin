package baekjoon.bruteforce

import kotlin.math.max

class `16987` {

    private var N = 0
    private var maxVal = 0
    private val eggs = mutableListOf<Egg>()

    data class Egg(
        var s:Int,
        val w:Int
    )

    private fun dfs(idx:Int){
        if (idx == N){
            maxVal = max(maxVal, eggs.count { it.s <= 0 })
            return
        }

        if (eggs[idx].s <= 0) // nextEgg
            dfs(idx + 1)
        else{
            var noTouchFlag = true
            for (i in eggs.indices){
                if (i != idx && eggs[i].s > 0){ // Non-broken Egg
                    noTouchFlag = false
                    eggs[idx].s -= eggs[i].w
                    eggs[i].s -= eggs[idx].w
                    dfs(idx + 1)
                    eggs[idx].s += eggs[i].w
                    eggs[i].s += eggs[idx].w
                }
            }

            if (noTouchFlag)
                dfs(idx + 1)
        }
    }

    fun solution():Int = with(System.`in`.bufferedReader()){
        N = readLine().toInt()
        eggs.apply{
            (1..N).forEach { _ ->
                val (S, W) = readLine().split(" ").map { it.toInt() }
                add(Egg(S, W))
            }
        }
        dfs(0)
        return maxVal
    }

}

fun main(){

    println(`16987`().solution())

}