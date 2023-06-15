package baekjoon.twopointer

class `6137` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val S = Array(N) { readLine()[0] }.toCharArray()

        val sb = StringBuilder()
        var left = 0
        var right = N - 1
        while (left <= right) {
            when {
                S[left] < S[right] -> {
                    sb.append(S[left])
                    left++
                }
                S[left] > S[right] -> {
                    sb.append(S[right])
                    right--
                }
                else -> {

                    var l = left + 1
                    var r = right - 1
                    while (l <= r) {
                        when {
                            S[l] < S[r] -> {
                                sb.append(S[left])
                                left++
                                break
                            }
                            S[l] > S[r] -> {
                                sb.append(S[right])
                                right--
                                break
                            }
                        }
                        l++; r--
                    }

                    if (l >= r) {
                        sb.append(S[left])
                        left++
                    }
                }
            }

        }
        print(sb.toString().chunked(80).joinToString("\n"))
    }

}

fun main() {

    `6137`().solution()

}