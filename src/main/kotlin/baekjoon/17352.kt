package baekjoon

class `17352` {

    fun findParent(node:Int, parent:IntArray):Int{
        if (parent[node] != node)
            parent[node] = findParent(parent[node], parent)
        return parent[node]
    }

    fun unionParent(a:Int, b:Int, parent:IntArray){
        val pa = findParent(a, parent)
        val pb = findParent(b, parent)

        if (pa <= pb)
            parent[pb] = pa
        else
            parent[pa] = pb
    }


    fun solution() = with(System.`in`.bufferedReader()) {

        var answer = ""
        val N = readLine().toInt()
        val parent = IntArray(N + 1){ it }
        repeat(N - 2) {
            val (A, B) = readLine().split(" ").map { it.toInt() }
            unionParent(A, B, parent)
        }

        val firstParent = parent[1]
        for (i in 2..N) {
            if (firstParent != findParent(i, parent)) {
                answer = "1 $i"
                break
            }
        }

        println(answer)
    }

}

fun main() {

    `17352`().solution()

}