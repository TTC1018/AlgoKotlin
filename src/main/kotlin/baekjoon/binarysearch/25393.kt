package baekjoon.binarysearch

import java.util.TreeSet
import java.util.StringTokenizer

class `25393` {
    fun solution() = with(System.`in`.bufferedReader()) {
        var N = readLine().toInt()
        val L = mutableMapOf<Int, TreeSet<Int>>()
        val R = mutableMapOf<Int, TreeSet<Int>>()
        while (N-- > 0) {
            val lr = StringTokenizer(readLine())
            val l = lr.nextToken().toInt()
            val r = lr.nextToken().toInt()
            L.getOrPut(l) { TreeSet() }.add(r)
            R.getOrPut(r) { TreeSet() }.add(l)
        }

        val answer = StringBuilder()
        var Q = readLine().toInt()
        while (Q-- > 0) {
            val lr = StringTokenizer(readLine())
            val l = lr.nextToken().toInt()
            val r = lr.nextToken().toInt()
            if (l !in L && r !in R) {
                answer.append(-1).append('\n')
            } else {
                val mr = L[l]?.ceiling(r)
                when (mr) {
                    null -> answer.append(-1).append('\n')
                    r -> answer.append(1).append('\n')
                    else -> {
                        val ml = R[r]?.floor(l)
                        if (ml == null) {
                            answer.append(-1).append('\n')
                        } else {
                            // [l~r초과] 존재하고 [l이하~r] 존재할때
                            answer.append(2).append('\n')
                        }
                    }
                }
            }
        }
        print(answer.dropLast(1))
    }
}