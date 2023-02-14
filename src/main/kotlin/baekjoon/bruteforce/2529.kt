package baekjoon.bruteforce

class `2529` {

    private var k = 0
    private lateinit var signs: List<String>
    private lateinit var nums:IntArray
    private val used = BooleanArray(9 + 1) { false }
    private val answers = mutableListOf<String>()

    private fun bruteforce(prev:Int, idx: Int) {
        if (idx == k){
            answers.add(nums.joinToString(""))
            return
        }

        when (signs[idx]){
            ">" -> {
                for (nxt in prev - 1 downTo 0){
                    if (used[nxt].not()){
                        used[nxt] = true
                        nums[idx + 1] = nxt
                        bruteforce(nxt, idx + 1)
                        nums[idx + 1] = 0
                        used[nxt] = false
                    }
                }
            }
            "<" -> {
                for (nxt in prev + 1..9){
                    if (used[nxt].not()){
                        nums[idx + 1] = nxt
                        used[nxt] = true
                        bruteforce(nxt, idx + 1)
                        nums[idx + 1] = 0
                        used[nxt] = false
                    }
                }
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()){

        k = readLine().toInt()
        signs = readLine().split(" ")
        nums = IntArray(k + 1)

        for (i in 0..9){
            nums[0] = i
            used[i] = true
            bruteforce(i, 0)
            used[i] = false
        }

        answers.sort()
        print("${answers.last()}\n${answers.first()}")
    }

}


fun main() {

    `2529`().solution()

}