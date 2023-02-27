package baekjoon.binarysearch

class `2631` {

    private var N = 0
    private lateinit var children: IntArray

    private fun binarySearch(target:Int, list:List<Int>): Int{
        var start = 0
        var end = list.size - 1


        while (start < end){
            val mid = (start + end) / 2

            if (list[mid] >= target){
                end = mid
            }
            else{
                start = mid + 1
            }
        }
        return end
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        N = readLine().toInt()
        children = IntArray(N) { readLine().toInt() }

        val seq = mutableListOf(children.first())
        for (i in 1 until N){
            if (children[i] > seq.last()){
                seq.add(children[i])
            }
            else{
                val idx = binarySearch(children[i], seq)
                seq[idx] = children[i]
            }
        }

        print(N - seq.size)
    }

}

fun main() {

    `2631`().solution()

}