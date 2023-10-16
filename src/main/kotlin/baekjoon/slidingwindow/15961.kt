package baekjoon.slidingwindow

class `15961` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, d, k, c) = readLine().split(" ").map(String::toInt)
        val S = List(N) { readLine().toInt() }

        // 슬라이딩 윈도우?
        // 원형이기 때문에 인덱스에 mod 필요
        var (s, e) = 0 to k - 1
        val counter = mutableMapOf<Int, Int>().apply {
            for (i in s..e) {
                this[S[i]] = getOrDefault(S[i], 0) + 1
            }
        }
        var answer = counter.size
        if (c !in counter)
            answer++

        while (s < N) {
            // 지나갈 초밥 차감
            counter[S[s]] = counter[S[s]]!! - 1
            if (counter[S[s]] == 0)
                counter.remove(S[s])
            s++

            // 범위 내의 새 초밥 카운트
            e = (e + 1) % N
            counter[S[e]] = counter.getOrDefault(S[e], 0) + 1

            // 쿠폰 유무 체크하고 최댓값 갱신
            answer = if (c !in counter)
                maxOf(answer, counter.size + 1)
            else
                maxOf(answer, counter.size)
        }

        print(answer)
    }
}