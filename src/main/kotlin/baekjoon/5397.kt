package baekjoon

class `5397` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val T = readLine().toInt()
        repeat(T){

            val origin = readLine()

            val leftOfCursor = ArrayDeque<Char>()
            val rightOfCursor = ArrayDeque<Char>()

            origin.forEach { str ->
                when(str) {
                    '<' -> {
                        if (leftOfCursor.isNotEmpty())
                            rightOfCursor.addFirst(leftOfCursor.removeLast())
                    }
                    '>' ->
                        if (rightOfCursor.isNotEmpty())
                            leftOfCursor.addLast(rightOfCursor.removeFirst())
                    '-' -> {
                        if (leftOfCursor.isNotEmpty())
                            leftOfCursor.removeLast()
                    }
                    else -> leftOfCursor.addLast(str)
                }
            }

            println(leftOfCursor.joinToString("") + rightOfCursor.joinToString(""))
        }

    }

}

fun main() {

    `5397`().solution()

}