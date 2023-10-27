package baekjoon.stack

class `2257` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val S = readLine()
        val tempNum = mutableListOf<Int>()
        val dict = buildMap<Char, Int> {
            put('H', 1)
            put('C', 12)
            put('O', 16)
        }

        for (s in S) {
            when (s) {
                '(' -> tempNum.add(-1)
                ')' -> {
                    var tempSum = 0
                    while (tempNum.isNotEmpty() && tempNum.last() != -1) {
                        tempSum += tempNum.removeLast()
                    }
                    tempNum.removeLastOrNull()
                    tempNum.add(tempSum)
                }
                else -> {
                    if (s.isDigit()) {
                        tempNum.add(tempNum.removeLast() * s.digitToInt())
                    } else {
                        tempNum.add(dict[s]!!)
                    }
                }
            }
        }

        print(tempNum.sumOf { it })
    }
}