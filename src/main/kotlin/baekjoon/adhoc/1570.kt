package baekjoon.adhoc

class `1570` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, sx, sy, mx, my) = readLine().split(" ").map(String::toInt)
        val dx = (mx - sx)
        val dy = (my - sy)
        if (dx < 0 || dy < 0) { // 뒤로 못감
            print(-1)
        } else {
            // R을 최대한 앞으로
            if (dx + dy < N) {
                print("R".repeat(dx) + "U".repeat(dy) + "R".repeat(N - dx - dy))
            } else {
                val cnt = (dx + dy) / N
                for (r in 0..N) {
                    val u = N - r
                    if (dx in r * cnt..r * (cnt + 1) && dy in u * cnt..u * (cnt + 1)) {
                        print(
                            "R".repeat(dx - r * cnt) +
                                    "U".repeat(dy - u * cnt) +
                                    "R".repeat(r - (dx - r * cnt)) +
                                    "U".repeat(u - (dy - u * cnt))
                        )
                        return
                    }
                }
                print(-1)
            }
        }
    }
}