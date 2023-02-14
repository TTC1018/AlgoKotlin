package baekjoon.string

class `1474` {

    fun solution() = with(System.`in`.bufferedReader()){
        val (N, M) = readLine().split(" ").map { it.toInt() }
        val words = Array<String>(N) { readLine() }
        val total = words.sumOf { it.length }

        // 일정하게 넣을 언더바 개수 구하기
        var minVal = 200
        for (l in 1..200){
            if (total + (words.size - 1)*l > M){
                minVal = l - 1
                break
            }
        }

        // 소문자 단어 앞에는 언더바 더 끼워넣기
        var left = M - (total + (words.size - 1) * minVal)
        var idx = 1
        val cnts = IntArray(N - 1) { 0 }
        while (left > 0 && idx < N){
            if (words[idx].first().isLowerCase()){
                cnts[idx - 1]++
                left--
            }
            idx++
        }

        // 남은 것은 대문자 단어 앞에 더 끼워넣기
        idx = N - 1
        while (left > 0 && idx >= 0){
            if (words[idx].first().isUpperCase()){
                cnts[idx - 1]++
                left--
            }
            idx--
        }

        val sb = StringBuilder(words.first())
        for (i in 1 until N){
            sb.append("_".repeat(cnts[i - 1]) + "_".repeat(minVal))
            sb.append(words[i])
        }
        print(sb.toString())
    }

}

fun main() {

    `1474`().solution()

}