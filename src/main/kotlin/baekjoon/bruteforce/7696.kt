package baekjoon.bruteforce

class `7696` {
    private data class NumAndBit(
        val num: String,
        val bit: Int,
    )

    private fun Int.toBit() = (1 shl this)

    fun solution() = with(System.`in`.bufferedReader()) {
        val answer = mutableListOf<String>()
        val q = ArrayDeque<NumAndBit>().apply {
            (1..9).forEach {
                add(NumAndBit(it.toString(), it.toBit()))
                answer.add(it.toString())
            }
        }

        while (q.isNotEmpty() && answer.size < 1000000) {
            val (num, bit) = q.removeFirst()
            (0..9).forEach {
                if (it.toBit() and bit == 0) {
                    q.add(NumAndBit("$num$it", bit or it.toBit()))
                    answer.add("$num$it")
                }
            }
        }

        val sb = StringBuilder()
        while (true) {
            val n = readLine().toInt()
            if (n == 0)
                break

            sb.appendLine(answer[n-1])
        }
        print(sb.dropLast(1))
    }
}