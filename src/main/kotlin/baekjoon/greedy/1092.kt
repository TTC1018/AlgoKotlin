package baekjoon.greedy

class `1092` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val cranes = readLine().split(" ").map { it.toInt() }.sortedDescending()
        var M = readLine().toInt()
        val boxes = readLine().split(" ").map { it.toInt() }.sortedDescending().toMutableList()
        // 제거보다는 접근이 많은 경우
        // LinkedList는 원소 접근에만 O(n)을 소모한다.
        // 차라리 제거에 O(n)이 드는 MutableList(ArrayList)를 쓰는 게 빠르다
        // 가장 빠른 방법은 이미 옮긴 원소는 방문처리하는 Boolean 배열을 두는 것

        if (boxes.first() > cranes.first())
            print(-1)
        else {
            var answer = 0
            while (boxes.isNotEmpty()) {
                for (crane in cranes) {
                    for (idx in boxes.indices) {
                        if (crane >= boxes[idx]) {
                            boxes.removeAt(idx)
                            break
                        }
                    }
                }
                answer++
            }
            print(answer)
        }

    }

}

fun main() {

    `1092`().solution()

}