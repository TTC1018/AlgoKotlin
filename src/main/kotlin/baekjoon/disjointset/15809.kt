package baekjoon.disjointset

class `15809` {
    private var N = 0
    private var M = 0
    private lateinit var A: List<Int>
    private lateinit var parent: IntArray
    private lateinit var power: IntArray

    private fun union(a: Int, b: Int) {
        val pa = find(a)
        val pb = find(b)

        if (pa < pb) {
            parent[pb] = pa
            power[pa] += power[pb]
        } else if (pa > pb) {
            parent[pa] = pb
            power[pb] += power[pa]
        }
    }

    private fun find(x: Int): Int {
        if (x != parent[x])
            parent[x] = find(parent[x])
        return parent[x]
    }

    private fun fight(a: Int, b: Int) {
        val pa = find(a)
        val pb = find(b)
        when {
            power[pa] == power[pb] -> {
                parent[pa] = -1
                parent[pb] = -1
                power[pa] = 0
                power[pb] = 0
            }
            power[pa] > power[pb] -> {
                power[pa] -= power[pb]
                parent[pb] = pa
            }
            power[pa] < power[pb] -> {
                power[pb] -= power[pa]
                parent[pa] = pb
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(' ').map(String::toInt).run {
            N = first(); M = last()
        }
        parent = IntArray(N) { it }
        A = List(N) { readLine().toInt() }
        power = A.toIntArray()
        repeat(M) {
            val (O, P, Q) = readLine().split(" ").map { it.toInt() - 1 }
            when (O) {
                0 -> union(P, Q)
                1 -> fight(P, Q)
            }
        }

        val answer = power.filterIndexed { i, v -> parent[i] == i && v > 0 }
        print(
            answer.run {
                var result = "$size"
                if (isNotEmpty())
                    result += "\n${sorted().joinToString(" ")}"
                result
            }
        )
    }
}