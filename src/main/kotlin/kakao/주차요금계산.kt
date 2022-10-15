package kakao

import java.util.TreeMap

class Solution92341 {

    companion object {
        private const val END_TIME = "23:59"
        private const val OP_IN = "IN"
        private const val OP_OUT = "OUT"
    }

    data class Record(
        val now: String,
        val total: Int,
        val state: String
    )

    private fun timeToMinute(time:String):Int{
        val (h, m) = time.split(":").map { it.toInt() }
        return h * 60 + m
    }

    fun solution(fees: IntArray, records: Array<String>): IntArray = with(System.`in`.bufferedReader()) {
        val answer = TreeMap<String, Int>()
        val feeRecord = mutableMapOf<String, Record>()

        val (sTime, sFee, unitTime, unitFee) = fees
        records.forEach { record ->
            val (timeStr, carNumStr, opStr) = record.split(" ")
            when (feeRecord[carNumStr]) {
                null -> feeRecord[carNumStr] = Record(timeStr, 0, OP_IN)
                else -> {
                    feeRecord[carNumStr]?.let { prevRecord ->
                        val prevTime = timeToMinute(prevRecord.now)
                        val prevTotal = prevRecord.total

                        when (opStr) {
                            OP_IN -> feeRecord[carNumStr] = Record(timeStr, prevTotal, OP_IN)
                            OP_OUT -> {
                                val nowTime = timeToMinute(timeStr)
                                val calcMin = nowTime - prevTime
                                feeRecord[carNumStr] = Record(timeStr, prevTotal + calcMin, OP_OUT)
                            }
                        }
                    }
                }
            }

        }

        val endTime = timeToMinute(END_TIME)
        feeRecord.forEach { (carNum, carRecord) ->
            val prevTime = timeToMinute(carRecord.now)
            when (carRecord.state) {
                OP_IN -> {
                    val totalTime = endTime - prevTime + carRecord.total
                    if (totalTime <= sTime)
                        answer[carNum] = sFee
                    else {
                        answer[carNum] = sFee + (totalTime - sTime + unitTime - 1) / unitTime * unitFee
                    }
                }

                OP_OUT -> {
                    val totalTime = carRecord.total
                    if (totalTime <= sTime)
                        answer[carNum] = sFee
                    else {
                        answer[carNum] = sFee + (totalTime - sTime + unitTime - 1) / unitTime * unitFee
                    }
                }
            }
        }

        return answer.values.toIntArray()
    }

}


fun main() {


        Solution92341().solution(
            intArrayOf(180, 5000, 10, 600),
            arrayOf(
                "05:34 5961 IN",
                "06:00 0000 IN",
                "06:34 0000 OUT",
                "07:59 5961 OUT",
                "07:59 0148 IN",
                "18:59 0000 IN",
                "19:09 0148 OUT",
                "22:59 5961 IN",
                "23:00 5961 OUT"
            )
        ).forEach {
            println(it)
        }


}