package baekjoon.stack

class `1406`{

    fun solution():String = with(System.`in`.bufferedReader()){
        val s = readLine()
        val M = readLine().toInt()
        val stackOne = ArrayDeque<String>().apply { s.forEach { add(it.toString()) } }
        val stackTwo = ArrayDeque<String>()

        repeat(M) {
            val ops = readLine()

            when(ops[0]) {
                'L' -> {
                    if (stackOne.isNotEmpty())
                        stackTwo.add(stackOne.removeLast())
                }
                'D' -> {
                    if (stackTwo.isNotEmpty())
                        stackOne.add(stackTwo.removeLast())
                }
                'B' -> {
                    if (stackOne.isNotEmpty())
                        stackOne.removeLast()
                }
                'P' -> {
                    val added = ops.split(" ").last()
                    stackOne.add(added)
                }
            }
        }

        stackOne.addAll(stackTwo.reversed())
        return stackOne.joinToString("")
    }
    
}

fun main(){
    print(`1406`().solution())
}