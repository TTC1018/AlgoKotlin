package baekjoon.bruteforce

class `1038` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val base = ('0'..'9').map { it.toString() }.toMutableList()
        val answers = base.toMutableList()

        var prevs = base.toMutableList()
        while (prevs.isNotEmpty()) {
            val nextTemp = mutableListOf<String>()

            for (prev in prevs) {
                base.forEach { num ->
                    if (prev.last().digitToInt() > num.toInt()) {
                        nextTemp.add(prev + num)
                    }
                }
            }

            answers.addAll(nextTemp)
            prevs = nextTemp
        }

        if (answers.size <= N) {
            print(-1)
        } else {
            print(answers[N])
        }
    }

}

fun main() {

    `1038`().solution()

}