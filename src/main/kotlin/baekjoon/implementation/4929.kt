package baekjoon.implementation

class `4929` {
    fun solution() = with(System.`in`.bufferedReader()) {
        while (true) {
            val a = readLine().split(" ").map(String::toInt)
            if (a.size == 1 && a.first() == 0)
                return
            val b = readLine().split(" ").map(String::toInt)

            val A = a.drop(1)
            val B = b.drop(1)
            var (p1, p2) = 0 to 0
            var (aSum, bSum) = 0 to 0
            var answer = 0
            while (p1 < a.first() || p2 < b.first()) {
                if (p1 < a.first() && p2 < b.first()) {
                    when {
                        A[p1] == B[p2] -> {
                            answer += maxOf(aSum, bSum) + A[p1]
                            p1++
                            p2++
                            aSum = 0
                            bSum = 0
                        }
                        A[p1] > B[p2] -> {
                            bSum += B[p2]
                            p2++
                        }
                        A[p1] < B[p2] -> {
                            aSum += A[p1]
                            p1++
                        }
                    }
                } else if (p1 < a.first()) {
                    aSum += A[p1]
                    p1++
                } else if (p2 < b.first()) {
                    bSum += B[p2]
                    p2++
                }
            }
            answer += maxOf(aSum, bSum)
            println(answer)
        }
    }
}