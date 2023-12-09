package baekjoon.stack

class `2812` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val num = readLine().toCharArray().map(Char::digitToInt)

        var cnt = K
        val stack = mutableListOf<Int>()
        for (n in num) {
            while (stack.isNotEmpty() && stack.last() < n && cnt > 0) {
                stack.removeLast()
                cnt--
            }
            stack.add(n)
        }

        while (cnt-- > 0) {
            stack.removeLast()
        }
        print(stack.joinToString(""))
    }
}