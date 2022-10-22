package baekjoon

class `25542` {

    private val NON_EXIST = "CALL FRIEND"
    private val alphas = ('A'..'Z').toList()

    private fun getCandidates(name: String): List<String> {
        val cands = mutableListOf<String>()
        val seperated: MutableList<Char> = name.toMutableList()

        for (i in seperated.indices) {
            val originChar = seperated[i]
            alphas.forEach {
                seperated[i] = it
                cands.add(seperated.joinToString(""))
            }
            seperated[i] = originChar
        }

        return cands
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, L) = readLine().split(" ").map { it.toInt() }
        val names = MutableList<String>(N) { readLine() }
        val cands = getCandidates(names.last())
        names.removeLast()

        for (cand in cands) {
            var answerFlag = true
            for (name in names) {
                var count = 0
                for (i in 0 until L) {
                    if (cand[i] != name[i])
                        count++
                }

                if (count > 1) {
                    answerFlag = false
                    break
                }
            }

            if (answerFlag) {
                println(cand)
                return
            }
        }

        println(NON_EXIST)
    }

}

fun main() {

    `25542`().solution()

}