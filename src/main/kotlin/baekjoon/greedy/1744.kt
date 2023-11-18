package baekjoon.greedy

class `1744` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val nums = List(N) { readLine().toInt() }
        val (plus, minus) = nums.partition { it > 0 }
        var answer = 0
        answer += minus.sorted().windowed(2, 2, true)
            .map {
                var sum = 1
                for (n in it)
                    sum *= n
                sum
            }.sumOf { it }
        answer += plus.sortedDescending().windowed(2, 2, true)
            .map {
                if (it.size == 1) {
                    it[0]
                } else {
                    var sum = 1
                    if (1 !in it) {
                        for (n in it)
                            sum *= n
                    } else {
                        sum += it.sumOf {  n -> n } - 1
                    }
                    sum
                }
            }.sumOf { it }
        print(answer)
    }
}