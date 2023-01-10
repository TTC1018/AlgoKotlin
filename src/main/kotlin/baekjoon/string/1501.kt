package baekjoon.string

class `1501` {

    private fun generateKey(s: String): String {
        val sb = StringBuilder().apply {
            append(s.first())
            if (s.length > 1)
                append(s.last())
        }

        val countArray = CharArray(58) // 시간 단축을 위해 IntArray 대신 CharArray 사용
        for (i in 1 until s.length - 1) {
            countArray[s[i] - 'A']++ // 알파벳 개수를 기록
        }
        sb.append(countArray)
        return sb.toString()
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().trim().toInt()
        val dict = Array(N) { readLine().trim() }

        val M = readLine().trim().toInt()
        val sentences = Array(M) { readLine().trim() }

        val cands = buildMap<String, Int> {
            dict.forEach {
                val key = generateKey(it)
                this[key] = getOrDefault(key, 0) + 1
            }
        }

        for (sentence in sentences) {
            val sList = sentence.split(" ")
            var result = 0
            for (s in sList) {
                val key = generateKey(s)
                if (key in cands) {
                    if (result == 0)
                        result = cands.getOrDefault(key, 0)
                    else
                        result *= cands.getOrDefault(key, 0)
                }

            }
            println(result)
        }

    }

}

fun main() {

    `1501`().solution()

}