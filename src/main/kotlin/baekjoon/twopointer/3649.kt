package baekjoon.twopointer

class `3649` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        while (true) {
            try {
                val x = readLine().toLong() * 10000000
                val n = readLine().toInt()
                if (n == 0) {
                    sb.append("danger").append('\n')
                    continue
                }
                val L = List(n) { readLine().toLong() }.sorted()

                var (l, r) = 0 to n - 1
                while (l < r) {
                    val sumVal = L[l] + L[r]
                    when {
                        sumVal == x -> {
                            sb.append("yes ${L[l]} ${L[r]}").append('\n')
                            break
                        }

                        sumVal > x -> {
                            r--
                        }

                        sumVal < x -> {
                            l++
                        }
                    }
                }
                if (l == r) {
                    sb.append("danger").append('\n')
                }
            } catch (e: Exception) {
                break
            }
        }
        print(sb.dropLast(1))
    }
}