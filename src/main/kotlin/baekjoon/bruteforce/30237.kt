package baekjoon.bruteforce

class `30237` {
    private var n = 0
    private lateinit var S: Map<Int, Int>
    private lateinit var A: List<Set<Int>>
    private var answer = 0

    private fun bruteforce(target: Int) {
        buildMap<Int, Int> {
            for (a in A) {
                if (target in a) {
                    for (num in a) {
                        this[num] = getOrDefault(num, 0) + 1
                    }
                }
            }

            val removed = S.size - keys.count { S.getOrDefault(it, 0) <= getOrDefault(it, 0) }
            if (removed != S.size) {
                answer = maxOf(answer, removed)
            }
        }
    }

    // S가 모든 부분 집합의 합집합은 아니다
    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            answer = 0
            S = buildMap {
                n = readLine().toInt()
                A = buildList {
                    repeat(n) {
                        val a = readLine().split(" ").map(String::toInt).drop(1).toSet()
                        for (num in a) {
                            this@buildMap[num] = this@buildMap.getOrDefault(num, 0) + 1
                        }
                        add(a)
                    }
                }
            }

            for (target in 1..50) {
                bruteforce(target)
            }
            sb.append(answer).append('\n')
        }
        print(sb.dropLast(1))
    }
}