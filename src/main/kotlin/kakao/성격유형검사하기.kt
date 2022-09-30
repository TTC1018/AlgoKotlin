package kakao

class Solution118666 {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""

        val pMap = mapOf(1 to 3, 2 to 2, 3 to 1, 4 to 0, 5 to 1, 6 to 2, 7 to 3)
        val persona = mutableMapOf(
            'R' to 0, 'T' to 0, 'C' to 0, 'F' to 0,
            'J' to 0, 'M' to 0, 'A' to 0, 'N' to 0
        )

        choices.zip(survey).forEach { (point, types) ->
            val plusPoint = pMap[point]
            plusPoint?.let {
                when (point){
                    in (1..3) -> persona[types[0]] = persona[types[0]]!! + it
                    in (5..7) -> persona[types[1]] = persona[types[1]]!! + it
                }
            }
        }

        // assertion 대신 쓸 수 있는 방법이 뭐가 있을까
        persona.keys.chunked(2).forEach {
            when {
                (persona[it[0]]!! > persona[it[1]]!!) -> answer += it[0]
                (persona[it[0]]!! < persona[it[1]]!!) -> answer += it[1]
                (persona[it[0]]!! == persona[it[1]]!!) -> answer += it.sorted()[0]
            }
        }

        return answer
    }
}



fun main(){
    println(Solution118666().solution(arrayOf("AN", "CF", "MJ", "RT", "NA"), intArrayOf(5, 3, 2, 7, 5)))
}