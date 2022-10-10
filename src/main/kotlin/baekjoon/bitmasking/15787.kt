package baekjoon.bitmasking

class `15787` {

    fun solution():Int = with(System.`in`.bufferedReader()){
        val (N, M) = readLine().split(" ").map { it.toInt() }
        val train = Array(N) { 0 }
        val maxBit = (1 shl 20) - 1
        (1..M).forEach { _ ->
            val op = readLine().split(" ")
            val opNum = op.first().toInt()
            val tNum = op[1].toInt() - 1
            when(opNum){
                1 -> {
                    op.getOrNull(2)?.let {
                        val seat = it.toInt()
                        train[tNum] = train[tNum] or (1 shl (seat - 1))
                    }
                }
                2 -> {
                    op.getOrNull(2)?.let {
                        val seat = it.toInt()
                        train[tNum] = train[tNum] and (1 shl (seat - 1)).inv()
                    }
                }
                3 -> {
                    train[tNum] = train[tNum] shl 1
                    train[tNum] = train[tNum] and maxBit
                }
                4 -> train[tNum] = train[tNum] shr 1
            }
        }

        return train.toSet().size
    }

}


fun main(){
    println(`15787`().solution())
}