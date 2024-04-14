package baekjoon.geometry

class `15916` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val y = readLine().split(" ").map(String::toLong)
        val k = readLine().toLong()
        var (up, down) = false to false
        for (i in y.indices) {
            val target = (i + 1) * k
            if (target == y[i]) {
                print('T')
                return
            }

            if (y[i] > target) {
                up = true
            } else if (y[i] < target) {
                down = true
            }
        }

        if (up && down) {
            print('T')
        } else {
            print('F')
        }
    }
}