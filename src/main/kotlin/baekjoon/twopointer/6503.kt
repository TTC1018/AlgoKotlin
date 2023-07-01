package baekjoon.twopointer

class `6503` {
    fun solution() = with(System.`in`.bufferedReader()) {
        while (true) {
            val m = readLine().toInt()
            if (m == 0)
                break

            val s = readLine()
            var answer = 1
            var (left, right) = listOf(0, 0)
            val counter = mutableMapOf<Char, Int>()
            while (left < s.length && right < s.length) {
                val pointed = s[right]
                when {
                    counter.size == m -> {
                        if (pointed !in counter) {
                            counter[s[left]] = counter.getOrDefault(s[left], 0) - 1
                            if (counter[s[left]] == 0)
                                counter.remove(s[left])
                            left++
                        } else {
                            answer = maxOf(answer, right - left + 1)
                            counter[pointed] = counter.getOrDefault(pointed, 0) + 1
                            right++
                        }
                    }

                    counter.size < m -> {
                        answer = maxOf(answer, right - left + 1)
                        counter[pointed] = counter.getOrDefault(pointed, 0) + 1
                        right++
                    }
                }
            }
            println(answer)
        }
    }
}

fun main() { `6503`().solution() }