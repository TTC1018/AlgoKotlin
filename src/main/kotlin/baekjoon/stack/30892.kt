package baekjoon.stack

class `30892` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K, T) = readLine().split(" ").map(String::toInt)
        val S = readLine().split(" ").map(String::toLong).sorted()
        val prev = mutableListOf<Long>()

        var now = T.toLong()
        var left = K
        for (s in S) {
            if (s < now) {
                prev.add(s)
            } else {
                while (left > 0 && prev.isNotEmpty() && now <= s) {
                    now += prev.removeLast()
                    left--
                }

                if (now > s) {
                    prev.add(s)
                } else {
                    break
                }
            }
        }

        while (left-- > 0 && prev.isNotEmpty()) {
            now += prev.removeLast()
        }
        print(now)
    }
}