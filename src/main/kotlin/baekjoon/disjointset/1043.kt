package baekjoon.disjointset

class `1043` {

    private var N = 0
    private var M = 0
    private var T = 0
    private lateinit var truth: Set<Int>
    private lateinit var parties: Array<IntArray>
    private lateinit var parent: IntArray

    private fun input(){
        with(System.`in`.bufferedReader()){
            readLine().split(" ").map { it.toInt() }
                .also { N = it.first(); M = it.last() }
            parent = IntArray(N + 1) { it }
            readLine().split(" ").map { it.toInt() }
                .also {
                    T = it.first()
                    truth = it.drop(1).toSet()
                }
            parties = Array(M) { readLine().split(" ").map { it.toInt() }.toIntArray() }
        }
    }

    private fun findParent(node: Int): Int{
        if (parent[node] != node)
            parent[node] = findParent(parent[node])
        return parent[node]
    }

    private fun union(a: Int, b: Int){
        val pa = findParent(a)
        val pb = findParent(b)

        if (pa in truth)
            parent[pb] = pa
        else
            parent[pa] = pb
    }


    fun solution() {
        input()

        // 거짓말을 안 들키는 법
        // 진실을 아는 사람이 없는 곳에서 거짓말하기
        // 진실을 아는 사람이 있는 곳에 포함된 모든 사람이 진실을 알게됨
        parties.forEach { party ->
            val members = party.drop(1).sorted()
            for (i in 1 until party.first()){
                union(members.first(), members[i])
            }
        }

        var answer = 0
        for (party in parties){
            val members = party.drop(1)

            var cnt = 0
            for (member in members){
                if (findParent(member) in truth)
                    break
                cnt++
            }

            answer += (cnt / party.first())
        }
        print(answer)
    }

}

fun main() {

    `1043`().solution()

}