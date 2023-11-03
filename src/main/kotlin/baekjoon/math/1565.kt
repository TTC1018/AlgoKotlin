package baekjoon.math

class `1565` {
    private fun lcm(A: Long, B: Long): Long {
        return (A * B) / gcd(A, B)
    }

    private fun gcd(A: Long, B: Long): Long {
        var (a, b) = listOf(A, B).sortedDescending()
        while (b > 0) {
            val mod = a % b
            a = b
            b = mod
        }
        return a
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N1, N2) = readLine().split(" ").map(String::toInt)
        val D = readLine().split(" ").map(String::toLong)
        val M = readLine().split(" ").map(String::toLong)
        // D의 공배수이자 M의 공약수
        // 최솟값 = D의 최소공배수 & M의 최대 공약수
        // 배열 크기 최대 50이라 완탐 가능할듯
        // 유클리드호제법으로 최대공약수 & 최소공배수 찾기
        val L = D.reduce { acc, l -> lcm(acc, l) }
        val G = M.reduce { acc, l -> gcd(acc, l) }
        var answer = 0
        var ptr = 1L
        while (ptr*ptr < G) { // G 전부 탐색하지말고 제곱근까지만 탐색
            if (G % ptr == 0L) { // G의 약수
                if (ptr % L == 0L) // L의 배수라면
                    answer++
                if ((G / ptr) % L == 0L) // ptr과 짝을 이루는 약수가 L의 배수라면
                    answer++
            }
            ptr++
        }
        if (ptr*ptr == G && ptr % L == 0L) // 정확한 제곱근은 하나만 세기
            answer++
        print(answer)
    }
}