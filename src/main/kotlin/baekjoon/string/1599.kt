package baekjoon.string

class `1599` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val S = Array(N) { readLine() }

        val convertMap = buildMap {
            val origin = "a b c d e f g h i j k l m n o p q r s t u v w x y z".split(" ")
            "a b k d e g h i l m n ng o p r s t u w y".split(" ")
                .forEachIndexed { index, s ->
                    put(s, origin[index])
                }
        }
        val converted = Array(N) {
            S[it].let { s ->
                buildList {
                    var idx = 0
                    while (idx < s.length) {
                        if (idx < s.length - 1 && s[idx] == 'n' && s[idx + 1] == 'g') {
                            add("${s[idx]}${s[idx + 1]}")
                            idx += 2
                        } else {
                            add("${s[idx]}")
                            idx++
                        }
                    }
                }
                    .map { convertMap[it] }
                    .joinToString("")
            }
        }

        print(
            converted
                .withIndex()
                .sortedBy { it.value }
                .joinToString("\n") { S[it.index] }
        )
    }
}

fun main() {
    `1599`().solution()
}