package baekjoon.adhoc

class `12947` {
    fun solutionn() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val cnt = readLine().split(" ").map(String::toInt)
        // 최대한 분기 시키는 것이 최대 지름을 만들어내는 방법
        // 하나만 분기 할 수 있는 시점에서 갱신해야 된다
        // 계속 두갈래로 가지를 치다보면,
        // 과거 분기점보다 더 긴 트리의 지름을 만들어내는 구간이 생긴다
        var prevMax = 0
        var seperated = 0
        for (i in cnt.indices) {
            prevMax++
            if (cnt[i] == 1) { // 더 연장할 수 있는 게 한 곳 뿐임
                // 계속 분기하던 구간과 지금까지 가장 길었던 구간을 비교
                prevMax = maxOf(prevMax, seperated + 1)
                seperated = 0
            } else {
                // 두 갈래로 분기
                seperated += 2
            }
        }
        print(maxOf(prevMax, seperated))
    }
}