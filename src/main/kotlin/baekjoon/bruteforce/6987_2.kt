package baekjoon.bruteforce

class `6987_2` {
    private val answer = IntArray(4)
    private lateinit var cand: List<IntArray>
    private val temp = IntArray(3 * 6)

    private fun bruteforce(a: Int, b: Int) {
        if (a == 5) {
            cand.forEachIndexed { i, arr ->
                if (answer[i] == 0 && temp.contentEquals(arr)) {
                    answer[i] = 1
                }
            }
            return
        }
        val nextA = if (b == 5) a + 1 else a
        val nextB = if (b == 5) a + 2 else b + 1
        // a 승
        temp[a * 3]++
        temp[b * 3 + 2]++
        bruteforce(nextA, nextB)
        temp[a * 3]--
        temp[b * 3 + 2]--
        // 무승부
        temp[a * 3 + 1]++
        temp[b * 3 + 1]++
        bruteforce(nextA, nextB)
        temp[a * 3 + 1]--
        temp[b * 3 + 1]--
        // b 승
        temp[a * 3 + 2]++
        temp[b * 3]++
        bruteforce(nextA, nextB)
        temp[a * 3 + 2]--
        temp[b * 3]--
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        cand = List(4) { readLine().split(" ").map(String::toInt).toIntArray() }
        bruteforce(0, 1)
        print(answer.joinToString(" "))
    }
}