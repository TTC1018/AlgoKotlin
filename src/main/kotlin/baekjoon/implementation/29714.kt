package baekjoon.implementation

class `29714` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val M = readLine().toInt()
        val counter = mutableMapOf<Int, Int>().apply {
            if (M > 0) {
                readLine().split(" ").map(String::toInt).forEach {
                    this[it] = getOrDefault(it, 0) + 1
                }
            }
        }
        repeat(readLine().toInt()) {
            val A = readLine().split(" ").drop(1).map(String::toInt)
                .groupingBy { it }.eachCount()
            val B = readLine().split(" ").drop(1).map(String::toInt)
                .groupingBy { it }.eachCount()
            if (A.isEmpty()) {
                B.forEach { (k, v) -> counter[k] = counter.getOrDefault(k, 0) + v }
            } else {
                if (A.all { (k, v) -> counter.getOrDefault(k, 0) >= v }) {
                    A.forEach { (k, v) -> counter[k] = counter.getOrDefault(k, 0) - v }
                    B.forEach { (k, v) -> counter[k] = counter.getOrDefault(k, 0) + v }
                }
            }
        }
        val answer = counter.map { (k, v) -> List(v) { "$k" }.joinToString(" ") }
            .joinToString(" ")
        val count = counter.values.sumOf { it }
        println(count)
        if (count > 0) {
            print(answer)
        }
    }
}