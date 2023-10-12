package baekjoon.string

private fun Char.toIndex() = this - 'a'

class `5670` {

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

    fun solution() = with(System.`in`.bufferedReader()) {
        try {
            while (true) {
                val N = readLine().toInt()
                val trie = Trie()
                buildList<String> {
                    repeat(N) {
                        val s = readLine()
                        trie.insert(s)
                        add(s)
                    }
                }.also {
                    var answer = 0.0
                    it.forEach { s ->
                        var ptr = trie.root
                        s.forEach { c ->
                            ptr.children[c.toIndex()]?.run {
                                if (children.count { it != null } > 1 || isTail) {
                                    answer++
                                }
                                ptr = this
                            }
                        }
                    }
                    println("%.2f".format(answer / N))
                }
            }
        } catch (e: Exception) {
            return
        }
    }
}

fun main() {
    `5670`().solution()
}