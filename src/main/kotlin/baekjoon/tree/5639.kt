package baekjoon.tree


class `5639` {
    private lateinit var nums: MutableList<Int>
    private fun postOrder(left: Int, right: Int) {
        if (left > right)
            return

        if (left == right) {
            println(nums[left])
            return
        }

        // 우측 자식 없는 경우 염두에 둔 초기화
        // (다음 재귀에 최상단 left > right에 걸려서 return 된다.)
        var splitPoint = right + 1
        for (i in left + 1..right) {
            if (nums[left] < nums[i]) {
                splitPoint = i
                break
            }
        }

        // 후위 순위에서는 자식노드부터 출력되어야 함
        postOrder(left + 1, splitPoint - 1) // 좌측 자식 노드들
        postOrder(splitPoint, right) // 우측 자식 노드들
        println(nums[left]) // 부모가 가장 마지막에 출력
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        nums = mutableListOf()
        while (true) {
            try {
                val num = readLine() ?: break
                if (num.isEmpty()) break
                nums.add(num.toInt())
            } catch (e: Exception) {
                break
            }
        }
        postOrder(0, nums.size - 1)
    }
}

fun main() {
    `5639`().solution()
}