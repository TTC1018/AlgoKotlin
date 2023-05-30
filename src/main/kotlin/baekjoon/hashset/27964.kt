package baekjoon.hashset

class `27964` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val T = readLine().split(" ")

        val answer = mutableSetOf<String>()

        for (t in T) {

            if (t.length >= 6 && t.endsWith("Cheese"))
                answer.add(t)

        }

        print(if (answer.size >= 4) "yummy" else "sad")

    }

}

fun main() {

    `27964`().solution()

}