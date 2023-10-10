package baekjoon.string

private fun Char.toIndex() = this - 'a'

class `19585` {
    private data class TrieNode(
        var key: Char? = null,
        val children: Array<TrieNode?> = Array(26) { null },
        var isTail: Boolean = false
    )

    private class Trie {
        val root = TrieNode()

        fun insert(color: String) {
            var ptr = root
            for (c in color) {
                ptr = ptr.children[c.toIndex()] ?: run {
                    val nextNode = TrieNode(c)
                    ptr.children[c.toIndex()] = nextNode
                    nextNode
                }
            }
            ptr.isTail = true
        }
    }

    private lateinit var colorTrie: Trie
    private lateinit var names: Set<String>

    private fun search(cand: String): Boolean {
        var nodePtr = colorTrie.root
        for (i in cand.indices) {
            val s = cand[i]
            if (nodePtr.isTail && cand.substring(i) in names) {
                return true
            }

            if (nodePtr.children[s.toIndex()] == null) {
                break
            }

            nodePtr = nodePtr.children[s.toIndex()]!!
        }
        return false
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val (C, N) = readLine().split(" ").map(String::toInt)
        colorTrie = Trie().apply {
            for (i in 0 until C) {
                insert(readLine())
            }
        }
        names = buildSet {
            for (i in 0 until N) {
                add(readLine())
            }
        }

        val answer = StringBuilder()
        for (i in 0 until readLine().toInt()) {
            val cand = readLine().trim()
            if (search(cand))
                answer.append("Yes").append("\n")
            else
                answer.append("No").append("\n")
        }
        print(answer)
    }
}

fun main() {
    `19585`().solution()
}