package baekjoon.bruteforce

class `16987` {
    private data class Egg(
        var s: Int,
        val w: Int
    )

    private var N = 0
    private lateinit var eggs: Array<Egg>
    private var answer = 0

    private fun bruteforce(idx: Int) {
        if (idx == N) {
            answer = maxOf(answer, eggs.count { it.s <= 0 })
            return
        }

        if (eggs[idx].s <= 0)
            bruteforce(idx + 1)
        else {
            var autoStep = true
            for (i in 0 until N) {
                if (i != idx && eggs[i].s > 0) {
                    autoStep = false
                    eggs[i].s -= eggs[idx].w
                    eggs[idx].s -= eggs[i].w
                    bruteforce(idx + 1)
                    eggs[i].s += eggs[idx].w
                    eggs[idx].s += eggs[i].w
                }
            }
            if (autoStep)
                bruteforce(idx + 1)
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        eggs = Array(N) { readLine().split(" ").map(String::toInt).let { Egg(it[0], it[1]) } }

        bruteforce(0)
        print(answer)
    }
}

fun main() {
    `16987`().solution()
}