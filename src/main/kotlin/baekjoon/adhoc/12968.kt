package baekjoon.adhoc

class `12968` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (R, C, K) = readLine().split(" ").map(String::toInt)
        // 모든 칸 K번 방문
        // 시작과 끝 -> 카운트 같아지려면 무조건 시작->끝을 찍어야 한다
        // 중간 칸 -> 시작 칸과 카운트 같음
        // 홀 & 홀 이라면 시작과 끝이 같아질 수 없음
        // 짝 & 짝 or 짝 & 홀 이라면 시작과 끝이 같아짐
        when {
            K == 1 -> print(1)
            R % 2 == 0 || C % 2 == 0 -> print(1)
            else -> print(0)
        }
    }
}