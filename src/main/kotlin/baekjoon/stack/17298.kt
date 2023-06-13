package baekjoon.stack

class `17298` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val A = readLine().split(" ").map(String::toInt).toIntArray()
        val bigNums = ArrayDeque<Int>()

        val answer = IntArray(N) { -1 }
        for (i in N - 1 downTo 0) {
            while (bigNums.isNotEmpty() && bigNums.last() <= A[i])
                bigNums.removeLast()

            if (bigNums.isNotEmpty())
                answer[i] = bigNums.last()

            bigNums.addLast(A[i])
        }

        print(answer.joinToString(" "))
    }

}

fun main() {

    `17298`().solution()

}