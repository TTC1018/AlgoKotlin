package baekjoon.graph

class `14267` {

    private var n = 0
    private var m = 0
    private lateinit var subs: Array<MutableList<Int>>
    private lateinit var counter: IntArray

    private fun input() = with(System.`in`.bufferedReader()){

        readLine().split(" ").map { it.toInt() }
            .also { n = it.first(); m = it.last() }

        subs = Array(n) { mutableListOf() }
        readLine().split(" ").map { it.toInt() - 1 }.forEachIndexed { i, s ->
            if (s >= 0)
                subs[s].add(i)
        }

        counter = IntArray(n)
        repeat(m) {
            readLine().split(" ").map { it.toInt() }
                .also { counter[it.first() - 1] += it.last() }
        }

    }

    private fun spread(i: Int){
        if (i == n)
            return

        for (sub in subs[i]){
            counter[sub] += counter[i]
            spread(sub)
        }
    }

    fun solution() {

        input()
        spread(0)
        print(counter.joinToString(" "))

    }

}

fun main() {

    `14267`().solution()

}