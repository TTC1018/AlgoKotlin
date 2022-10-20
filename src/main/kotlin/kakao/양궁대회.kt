package kakao

class Solution92342 {

    private var lastIdx = 10
    private var maxScore = 1
    private lateinit var apeachArrow: IntArray
    private var answers = mutableListOf<IntArray>()

    private fun calcScore(lion: IntArray): Int {
        var result = 0
        for (i in 0..lastIdx) {
            if (apeachArrow[i] == 0 && lion[i] == 0)
                continue

            if (apeachArrow[i] >= lion[i])
                result -= (10 - i)
            else
                result += (10 - i)
        }
        return result
    }

    private fun backTracking(nowIdx: Int, left: Int, arrows: IntArray) {
        if (left == 0 || nowIdx == lastIdx) {
            if (left != 0)
                arrows[nowIdx] = left

            val sumScore = calcScore(arrows)
            if (maxScore < sumScore) {
                maxScore = sumScore
                answers = mutableListOf(arrows.clone())
            } else if (maxScore == sumScore) {
                answers.add(arrows.clone())
            }

            arrows[nowIdx] = 0
            return
        }

        for (i in nowIdx until lastIdx) {
            if (apeachArrow[i] < left) {
                arrows[i] += apeachArrow[i] + 1
                backTracking(i + 1, left - arrows[i], arrows)
                arrows[i] -= apeachArrow[i] + 1
            } else {
                backTracking(i + 1, left, arrows)
            }
        }
    }

    fun solution(n: Int, info: IntArray): IntArray {
        apeachArrow = info

        backTracking(0, n, IntArray(11) { 0 })

        answers.sortWith(
            compareBy(
                { -it[10] },
                { -it[9] },
                { -it[8] },
                { -it[7] },
                { -it[6] },
                { -it[5] },
                { -it[4] },
                { -it[3] },
                { -it[2] },
                { -it[1] },
                { -it[0] })
        )

        if (answers.size == 0)
            return intArrayOf(-1)
        return answers.first()
    }

}

fun main() {

    println(Solution92342().solution(5, intArrayOf(2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0)).joinToString(" "))

}