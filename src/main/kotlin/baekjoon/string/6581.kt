package baekjoon.string

import java.util.StringTokenizer

class `6581` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val words = StringTokenizer(readText())
        val sb = StringBuilder()
        var nowLen = 0
        while (words.hasMoreTokens()) {
            when (val word = words.nextToken()) {
                "<br>" -> {
                    nowLen = 0
                    sb.appendLine()
                }

                "<hr>" -> {
                    if (nowLen > 0)
                        sb.appendLine()
                    nowLen = 0
                    sb.appendLine("-".repeat(80))
                }

                else -> {
                    when {
                        nowLen == 0 -> {
                            nowLen = word.length
                            sb.append(word)
                        }

                        nowLen + word.length >= 80 -> {
                            nowLen = word.length
                            sb.appendLine()
                            sb.append(word)
                        }

                        else -> {
                            nowLen += word.length + 1
                            sb.append(" $word")
                        }
                    }
                }
            }
        }

        println(sb)
    }
}