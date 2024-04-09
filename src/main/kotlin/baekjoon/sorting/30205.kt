package baekjoon.sorting

class `30205` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M, P) = readLine().split(" ").map(String::toInt)
        val s = List(N) { readLine().split(" ").map(String::toInt).sorted() }
        var now = P.toLong()
        for (floor in s) {
            var item = 0
            for (met in floor) {
                if (met == -1) {
                    item++
                } else {
                    while (item > 0 && now < met) {
                        item--
                        now *= 2
                    }

                    if (now < met) {
                        print(0)
                        return
                    } else {
                        now += met
                    }
                }
            }

            while (item-- > 0) {
                now *= 2
            }
        }
        print(1)
    }
}