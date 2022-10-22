package baekjoon.bruteforce

class `25542` {

    private val NON_EXIST = "CALL FRIEND"
    private val alphas = ('A'..'Z').toList()
    private lateinit var names:MutableList<String>

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

    private fun checkAnswer(cand:String, L:Int):Boolean{
        for (name in names) { // 함수로 바꿔보기
            var count = 0
            for (i in 0 until L) {
                if (cand[i] != name[i])
                    count++
            }

            if (count > 1)
                return false
        }
        return true
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, L) = readLine().split(" ").map { it.toInt() }
        names = MutableList(N) { readLine() }
        val cands = getCandidates(names.removeLast())

        for (cand in cands) {
            if (checkAnswer(cand, L)){
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