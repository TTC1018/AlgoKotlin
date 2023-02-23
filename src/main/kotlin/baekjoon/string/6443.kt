package baekjoon.string

class `6443` {

    private var N = 0
    private lateinit var words: Array<String>
    private val answers = mutableSetOf<String>()
    private val azLength = 'z' - 'a' + 1
    private val aToZ = ('a'..'z').toList()
    private val counter = IntArray(azLength)
    private val sb = StringBuilder()

    private fun generate(word:String){

        word.forEach { counter[it - 'a']++ }
        bruteforce(word.length)
        word.forEach { counter[it - 'a']-- }
    }

    private fun bruteforce(limit: Int){
        if (sb.length == limit){
            answers.add(sb.toString())
            return
        }

        for (i in 0 until azLength){
            if (counter[i] > 0){
                counter[i]--
                sb.append(aToZ[i])
                bruteforce(limit)
                sb.deleteAt(sb.length - 1)
                counter[i]++
            }
        }

    }

    fun solution() = with(System.`in`.bufferedReader()) {

        N = readLine().toInt()
        words = Array(N) { readLine() }
        words.forEach { generate(it) }
        print(answers.joinToString("\n"))

    }

}

fun main() {

    `6443`().solution()

}