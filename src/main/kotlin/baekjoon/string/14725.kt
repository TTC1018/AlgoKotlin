package baekjoon.string

class `14725` {

    data class Node(
        val next: MutableMap<String, Node> = mutableMapOf()
    )

    class Trie {
        val head = Node()

        fun insert(s: List<String>){
            var current = head

            for (c in s) {
                if (c !in current.next) // 초기화
                    current.next[c] = Node()
                current = current.next[c]!!
            }
            current.next["$"] = Node() // 끝 처리
        }

        fun show(length: Int, current: Node){
            if ("$" in current.next)
                return

            for (c in current.next.keys.sorted()){
                println("--".repeat(length) + c)
                show(length + 1, current.next[c]!!)
            }
        }
    }


    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val trie = Trie()

        repeat(N) {

            readLine().split(" ").drop(1).also { trie.insert(it) }

        }

        trie.show(0, trie.head)
    }

}

fun main() {

    `14725`().solution()

}