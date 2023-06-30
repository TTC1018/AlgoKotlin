package baekjoon.bruteforce

class `16943` {

    private lateinit var A: String
    private lateinit var B: String
    private lateinit var aChecked: BooleanArray

    private val sb = StringBuilder()
    private var answer = -1
    private fun bruteforce(idx: Int) {
        if (idx == B.length) {
            val cand = sb.toString()
            if (cand.toInt() < B.toInt() && cand.startsWith('0').not())
                answer = maxOf(answer, cand.toInt())
            return
        }

        for (j in A.indices) {
            if (aChecked[j].not()) {
                aChecked[j] = true
                sb.append(A[j])
                bruteforce(idx + 1)
                sb.deleteAt(sb.length - 1)
                aChecked[j] = false
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").also { A = it[0]; B = it[1] }
        when {
            A.length < B.length -> {
                val counter = A.groupBy { it }.mapValues { it.value.size }.toSortedMap(reverseOrder())
                print(counter.map { (k, v) -> k.toString().repeat(v) }.joinToString(""))
            }

            A.length == B.length -> {
                aChecked = BooleanArray(A.length) { false }
                bruteforce(0)
                print(answer)
            }

            else -> print(-1)
        }
    }

}

fun main() { `16943`().solution() }