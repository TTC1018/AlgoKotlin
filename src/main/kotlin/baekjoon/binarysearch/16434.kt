package baekjoon.binarysearch

class `16434` {
    private data class Room(
        val t: Int,
        val a: Int,
        val h: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, atk) = readLine().split(" ").map(String::toInt)
        var (l, r) = 1L to 0L
        val R = List(N) {
            readLine().split(" ").map(String::toInt).run {
                if (first() == 1) {
                    r += (this[1].toLong() * last())
                }
                Room(first(), this[1], last())
            }
        }

        while (l <= r) {
            val m = (l + r).div(2)
            var hp = m
            var atkNow = atk.toLong()
            for ((t, a, h) in R) {
                when (t) {
                    1 -> {
                        val hit = kotlin.math.ceil(h.toDouble() / atkNow).toLong()
                        hp -= a * (hit - 1)
                        if (hp <= 0) {
                            break
                        }
                    }

                    2 -> {
                        atkNow += a
                        hp = (hp + h).coerceAtMost(m)
                    }
                }
            }

            if (hp > 0) {
                r = m - 1
            } else {
                l = m + 1
            }
        }
        print(l)
    }
}