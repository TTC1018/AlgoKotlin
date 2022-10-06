package baekjoon.implementation

class `11637` {

    fun solution() = with(System.`in`.bufferedReader()){
        val T = readLine().toInt()

        (1..T).forEach { _ ->
            val n = readLine().toInt()
            var total = 0
            var maxVal = 0
            var winners = mutableListOf<Int>()
            for (i in 1..n) {
                val tickets = readLine().toInt()
                total += tickets
                if (tickets > maxVal){
                    maxVal = tickets
                    winners = mutableListOf(i)
                }
                else if (tickets == maxVal){
                    winners.add(i)
                }
            }

            if (winners.size == 1)
                when {
                    maxVal > total.div(2) ->
                        println("majority winner ${winners.first()}")
                    else ->
                        println("minority winner ${winners.first()}")
                }
            else
                println("no winner")
        }
    }

}

fun main(){
    `11637`().solution()
}