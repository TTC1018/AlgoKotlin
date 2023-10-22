package baekjoon.stack

class `24523` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val nums = readLine().split(" ").map(String::toInt)
        val stack = ArrayDeque<IndexedValue<Int>>()

        val answer = IntArray(N) { -1 }
        for (i in N - 1 downTo 0) {
            while (stack.lastOrNull()?.value == nums[i]) {
                stack.removeLast()
            }

            stack.lastOrNull()?.takeIf { it.value != nums[i] }
                ?.run {
                    answer[i] = this.index+1
                    stack.add(IndexedValue(i, nums[i]))
                } ?: run {
                stack.add(IndexedValue(i, nums[i]))
            }
        }
        print(answer.joinToString(" "))
    }
}