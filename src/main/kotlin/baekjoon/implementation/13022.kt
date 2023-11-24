package baekjoon.implementation

class `13022` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val S = readLine()
        val prevMap = buildMap {
            put('w', 'f')
            put('o', 'w')
            put('l', 'o')
            put('f', 'l')
        }
        val idx = buildMap {
            "wolf".forEachIndexed { i, c -> put(c, i) }
        }
        var target = 'w'
        val counter = IntArray(4)
        for (s in S) {
            if (target != s) {
                if (target == 'f' && s == 'w') { // 갱신 시점
                    if (counter.distinct().size > 1) {
                        print(0)
                        return
                    }
                    counter.fill(0)
                } else if (target != prevMap[s]!!) {
                    print(0)
                    return
                }
                target = s
            }
            counter[idx[s]!!]++
        }

        if (counter.distinct().size == 1)
            print(1)
        else
            print(0)
    }
}