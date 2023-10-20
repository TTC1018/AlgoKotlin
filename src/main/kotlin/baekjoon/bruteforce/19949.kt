package baekjoon.bruteforce

class `19949` {
    private lateinit var P: List<Int>
    private val prevTwo = ArrayDeque<Int>()
    private var tempCnt = 0
    private var answer = 0

    private fun bruteforce(now: Int) {
        if (now == 10) {
            if (tempCnt >= 5)
                answer++
            return
        }

        for (i in 1..5) {
            if (prevTwo.size < 2) {
                prevTwo.addLast(i)
                if (P[now] == i)
                    tempCnt++
                bruteforce(now+1)
                if (P[now] == i)
                    tempCnt--
                prevTwo.removeLast()
            }
            else if (prevTwo.size == 2 && (prevTwo[0] != i || prevTwo[1] != i)) {
                val removed = prevTwo.removeFirst()
                prevTwo.addLast(i)
                if (P[now] == i)
                    tempCnt++
                bruteforce(now+1)
                if (P[now] == i)
                    tempCnt--
                prevTwo.removeLast()
                prevTwo.addFirst(removed)
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        P = readLine().split(" ").map(String::toInt)
        bruteforce(0)
        print(answer)
    }
}