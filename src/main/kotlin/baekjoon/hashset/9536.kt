package baekjoon.hashset

class `9536` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            val map = mutableSetOf<String>()
            val sound = readLine().split(" ")
            while (true) {
                val s = readLine()
                if (s == "what does the fox say?") {
                    break
                }
                map.add(s.split(" goes ").last())
            }
            sb.appendLine(sound.filter { it !in map }.joinToString(" "))
        }
        print(sb.dropLast(1))
    }
}