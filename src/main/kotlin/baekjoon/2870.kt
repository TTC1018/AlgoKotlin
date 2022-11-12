package baekjoon

class `2870` {

    private fun generateString(temp:String):String{
        val zeroRemoved = temp.dropWhile { it == '0' }
        return if (zeroRemoved.isEmpty())
            "0"
        else
            zeroRemoved
    }

    fun solution() = with(System.`in`.bufferedReader()){

        val N = readLine().toInt()
        val strings = List(N) { readLine() }
        val nums = mutableListOf<String>()

        for (s in strings){
            val sb = StringBuilder()
            for (c in s){
                if (c.isDigit())
                    sb.append(c)
                else if (sb.isNotEmpty()){
                    nums.add(generateString(sb.toString()))
                    sb.clear()
                }
            }

            if (sb.isNotEmpty()) {
                nums.add(generateString(sb.toString()))
            }
        }

        nums.sortWith(compareBy({it.length}, {it}))
        println(nums.joinToString("\n"))
    }

}

fun main() {

    `2870`().solution()

}