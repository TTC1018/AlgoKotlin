package baekjoon.string

class `9519` {

    private var X = 0
    private lateinit var word: String
    private val visited = linkedSetOf<String>()

    // acefdb
    // aedbfc
    // adfcbe
    // afbecd
    // abcdef
    // acefdb

    fun solution() = with(System.`in`.bufferedReader()){

        X = readLine().toInt()
        word = readLine()

        var newWord = word
        while (newWord !in visited){
            visited.add(newWord)
            newWord = newWord
                .withIndex()
                .partition { c -> c.index % 2 == 0 }
                .run { first.map { it.value }.joinToString("") + second.map { it.value }.reversed().joinToString("") }
        }

        println(visited.toList()[X.mod(visited.size)])

    }

}

fun main() {

    `9519`().solution()

}