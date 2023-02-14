package baekjoon.twopointer

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()){

    val (N, K) = readLine().split(" ").map { it.toInt() }
    val a = readLine().split(" ").map { it.toInt() }.toIntArray()
    val cnt = IntArray(100000 + 1) { 0 }

    var left = 0
    var right = 0
    var answer = 1

    while (right < N){
        if (cnt[a[right]] < K){
            cnt[a[right]]++
            right++
        }
        else {
            cnt[a[left]]--
            left++
        }
        answer = max(answer, right - left)
    }
    print(answer)

}