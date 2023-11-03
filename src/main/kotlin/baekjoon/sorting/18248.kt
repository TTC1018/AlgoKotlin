package baekjoon.sorting

class `18248` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val B = List(N) { readLine().split(" ").map(String::toInt) }
            .sortedByDescending { row -> row.sumOf { it } }
        // 매번 종소리 범위가 바뀜
        // A가 듣고 B가 못들음 -> A가 종에 더 가깝다는 것
        // 위 관계는 절대 역전 될 수 없음
        // 종소리 많이 들은 행으로 정렬하면 관계가 역전되는지 파악가능
        for (j in 0 until M) {
            for (i in 1 until N) {
                if (B[i-1][j] < B[i][j]) {
                    print("NO")
                    return
                }
            }
        }
        print("YES")
    }
}