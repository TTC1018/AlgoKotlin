package baekjoon.dp

class `1229` {

    private fun lowerBound(nums: IntArray, target: Int) :Int{
        var left = 0
        var right = nums.size - 1

        while (left <= right){
            val mid = left + (right - left).div(2)

            if (nums[mid] >= target){
                right = mid - 1
            }
            else {
                left = mid + 1
            }
        }

        return left
    }

    fun solution() = with(System.`in`.bufferedReader()){

        val N = readLine().toInt()
        // h1 = 1
        // h2 = (2 * 6 - 6)
        // h3 = (2 * 6 - 6) + (3 * 4 - 3)
        // h4 = h3 + (4 * 4 - 3)

        println(lowerBound(intArrayOf(1, 2, 3), 1))

    }

}

fun main() {

    `1229`().solution()

}