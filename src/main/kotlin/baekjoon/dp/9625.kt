package baekjoon.dp

class `9625` {

    fun solution():String = with(System.`in`.bufferedReader()){

        val K = readLine().toInt()
        val S = Array(2) { Array(K + 1) {0} }

        S[1][1] = 1
        for (i in 2..K){
            S[1][i] += S[0][i - 1] + S[1][i - 1]
            S[0][i] += S[1][i - 1]
        }

        return "${S[0][K]} ${S[1][K]}"
    }

}

fun main(){
    print(`9625`().solution())
}
