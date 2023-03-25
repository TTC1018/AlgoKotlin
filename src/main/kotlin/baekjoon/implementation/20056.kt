package baekjoon.implementation

class `20056` {

    data class Pos(
        val x: Int,
        val y: Int
    )

    data class Fireball(
        val r: Int,
        val c: Int,
        val m: Int,
        val s: Int,
        val d: Int
    )

    private var N = 0
    private var M = 0
    private var K = 0
    private lateinit var fireballs: MutableList<Fireball>
    private val direc = arrayOf(
        Pos(-1, 0), Pos(-1, 1), Pos(0, 1),
        Pos(1, 1), Pos(1, 0), Pos(1, -1),
        Pos(0, -1), Pos(-1, -1)
    )

    private fun seperate(loc: Pos, mTotal: Int, sTotal: Int, size: Int, flag: Boolean) {
        val (x, y) = loc
        val mSeper = mTotal.div(5)
        val sSeper = sTotal.div(size)

        if (mSeper > 0) {
            when (flag) {
                true -> for (newD in 0..6 step 2) fireballs.add(Fireball(x, y, mSeper, sSeper, newD))
                false -> for (newD in 1..7 step 2) fireballs.add(Fireball(x, y, mSeper, sSeper, newD))
            }
        }

    }

    private fun start() {

        val locMap = mutableMapOf<Pos, MutableList<Fireball>>()
        for (fb in fireballs) {
            val (r, c, _, s, d) = fb
            val nr = (r + s * direc[d].x).mod(N)
            val nc = (c + s * direc[d].y).mod(N)
            val newLoc = Pos(nr, nc)
            if (locMap.containsKey(newLoc).not())
                locMap[newLoc] = mutableListOf()
            locMap[newLoc]!!.add(fb)
        }
        fireballs.clear()

        for ((loc, fbs) in locMap) {
            when (fbs.size) {
                1 -> fireballs.add(Fireball(loc.x, loc.y, fbs[0].m, fbs[0].s, fbs[0].d))
                else -> {
                    var mTotal = 0
                    var sTotal = 0
                    var oddFlag = false
                    var evenFlag = false

                    for ((_, _, m, s, d) in fbs) {
                        mTotal += m
                        sTotal += s
                        when (d % 2) {
                            0 -> evenFlag = true
                            1 -> oddFlag = true
                        }
                    }

                    if (oddFlag && evenFlag)
                        seperate(loc, mTotal, sTotal, fbs.size, false)
                    else
                        seperate(loc, mTotal, sTotal, fbs.size, true)
                }
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map { it.toInt() }
            .also { N = it[0]; M = it[1]; K = it[2] }
        fireballs = MutableList(M) {
            readLine().split(" ").map { it.toInt() }.run {
                Fireball(this[0] - 1, this[1] - 1, this[2], this[3], this[4])
            }
        }

        repeat(K) { start() }

        print(fireballs.sumOf { it.m })
    }

}

fun main() {

    `20056`().solution()

}