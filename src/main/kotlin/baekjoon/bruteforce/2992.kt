package baekjoon.bruteforce

class `2992` {
    private lateinit var X: String
    private val nums = mutableListOf<String>()
    private lateinit var V: BooleanArray
    private val sb = StringBuilder()

    private fun bruteforce(cnt: Int) {
        if (cnt == X.length) {
            nums.add(sb.toString())
            return
        }

        for (i in X.indices) {
            if (V[i].not()) {
                V[i] = true
                sb.append(X[i])
                bruteforce(cnt + 1)
                sb.deleteAt(sb.length - 1)
                V[i] = false
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        X = readLine()
        V = BooleanArray(X.length) { false }
        bruteforce(0)
        val target = X.toInt()
        for (n in nums.map(String::toInt).sorted()) {
            if (n > target) {
                print(n)
                return
            }
        }
        print(0)
    }
}