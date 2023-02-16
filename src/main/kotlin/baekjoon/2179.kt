package baekjoon

import kotlin.math.max
import kotlin.math.min

class `2179` {

    private var N = 0
    private lateinit var words: Array<String>

    fun solution() = with(System.`in`.bufferedReader()){

        N = readLine().toInt()
        words = Array(N) { readLine() }
        val wordsSorted = words.withIndex().sortedBy { it.value } // 가장 근접한 문자열이 접두사가 가장 많이 일치함

        val longest = IntArray(N) { 0 }
        var maxLength = 0
        for (i in 1 until N){
            if (words[i - 1] != words[i]){
                var tmp = 0
                for (j in 0 until min(wordsSorted[i - 1].value.length, wordsSorted[i].value.length)){
                    if (wordsSorted[i - 1].value[j] != wordsSorted[i].value[j])
                        break
                    tmp++
                }

                // 일치한 접두사의 길이를 계속해서 갱신
                longest[wordsSorted[i].index] = max(longest[wordsSorted[i].index], tmp)
                longest[wordsSorted[i - 1].index] = max(longest[wordsSorted[i - 1].index], tmp)
                maxLength = max(maxLength, tmp)
            }
        }

        for (i in 0 until N){
            if (longest[i] == maxLength){
                for (j in i + 1 until N){
                    if (words[j].length >= maxLength) // 접두사 이상의 길이를 갖는 문자열
                        if (words[i].slice(0 until maxLength) == words[j].slice(0 until maxLength)){
                            print("${words[i]}\n${words[j]}") // 접두사가 일치하는 대상이라면
                            return
                        }
                }
            }
        }
    }
}

fun main() {

    `2179`().solution()

}