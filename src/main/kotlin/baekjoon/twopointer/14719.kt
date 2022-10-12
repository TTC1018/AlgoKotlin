package baekjoon.twopointer

import kotlin.math.max

class `14719` {

    fun solution():Int = with(System.`in`.bufferedReader()){
        val (H, W) = readLine().split(" ").map { it.toInt() }
        val blocks = readLine().split(" ").map { it.toInt() }

        var left = 0
        var right = W - 1
        var leftMax = blocks.first()
        var rightMax = blocks.last()
        var water = 0

        while (left < right){
            leftMax = max(leftMax, blocks[left])
            rightMax = max(rightMax, blocks[right])

            if (leftMax <= rightMax){
                water += (leftMax - blocks[left])
                left += 1
            }
            else{
                water += (rightMax - blocks[right])
                right -= 1
            }
        }

        return water
    }

}

fun main(){

    println(`14719`().solution())

}