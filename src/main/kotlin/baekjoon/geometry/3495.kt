package baekjoon.geometry

class `3495` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val (h, w) = readLine().split(" ").map(String::toInt)
        val B = Array(h) { readLine().toCharArray() }

        var answer = 0
        for (i in 0 until h) {
            var cnt = 0
            for (j in 0 until w) {
                if (B[i][j] == '/' || B[i][j] == '\\')
                    cnt++

                // 슬래시가 홀수 개라면, 넓이 내부 공간이다.
                if (cnt % 2 != 0 && B[i][j] == '.')
                    answer++
            }
            answer += (cnt.div(2))
        }
        print(answer)
    }

}

fun main() {

    `3495`().solution()

}