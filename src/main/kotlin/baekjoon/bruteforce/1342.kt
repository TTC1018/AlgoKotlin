package baekjoon.bruteforce

class `1342` {

    private lateinit var S: String
    private val counter = IntArray('z' - 'a' + 1)
    private val sb = StringBuilder()
    private var answer = 0

    private fun isLucky(s: String): Boolean {
        for (i in 1 until s.length){
            if (s[i] == s[i - 1])
                return false
        }
        return true
    }

    private fun bruteforce(cnt: Int) {
        if (cnt == S.length){
            if (isLucky(sb.toString()))
                answer++
            return
        }

        for (i in counter.indices){
            if (counter[i] > 0){
                counter[i]--
                sb.append('a' + i)
                bruteforce(cnt + 1)
                sb.deleteAt(sb.length - 1)
                counter[i]++
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()){

        S = readLine()
        S.forEach { counter[it - 'a']++ }
        bruteforce(0)
        print(answer)
    }

}

fun main() {

    `1342`().solution()

}