package baekjoon.string

class `4889` {

    fun solution() = with(System.`in`.bufferedReader()){

        val answers = mutableListOf<String>()
        var order = 1
        while (true){

            val s = readLine()
            if (s.first() == '-')
                break

            val lClose = ArrayDeque<Char>()
            var answer = 0
            for (c in s){
                when (c) {
                    '{' -> lClose.add('{')
                    '}' -> {
                        if (lClose.lastOrNull() != null)
                            lClose.removeLast()
                        else{
                            lClose.add('{')
                            answer++
                        }
                    }
                }
            }

            answer += lClose.size / 2
            answers.add("$order. $answer")
            order++
        }

        print(answers.joinToString("\n"))
    }

}


fun main() {

    `4889`().solution()

}