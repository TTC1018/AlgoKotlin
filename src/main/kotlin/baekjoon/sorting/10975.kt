package baekjoon.sorting

class `10975` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val nums = List(N) { readLine().toInt() }.withIndex().sortedBy { it.value }
        var answer = 0
        for (i in nums.indices) {
            // 내가 추가해야 하는 경우 = 앞이나 뒷 숫자가 뒤 순서에 있을 때
            if (nums[i].index < (nums.getOrNull(i - 1)?.index ?: N) &&
                nums[i].index < (nums.getOrNull(i + 1)?.index ?: N)
            ) {
                answer++
            }
        }
        print(answer.takeIf { it > 0 } ?: 1)
    }
}