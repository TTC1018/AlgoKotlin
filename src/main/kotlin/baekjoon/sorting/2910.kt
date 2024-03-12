package baekjoon.sorting

class `2910` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, C) = readLine().split(" ").map(String::toInt)
        val nums = readLine().split(" ").map(String::toInt)
        val counter = nums.groupingBy { it }.eachCount()
        val firstIdx = buildMap<Int, Int> {
            for (i in 0 until N) {
                putIfAbsent(nums[i], i)
            }
        }

        print(
            nums.sortedWith(
                object : Comparator<Int> {
                    override fun compare(o1: Int?, o2: Int?): Int {
                        if (counter[o1]!! != counter[o2]!!)
                            return counter[o2]!!.compareTo(counter[o1]!!)

                        return firstIdx[o1]!!.compareTo(firstIdx[o2]!!)
                    }
                }
            ).joinToString(" ")
        )
    }
}