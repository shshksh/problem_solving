package programmers.kakao

fun solution(gems: Array<String>): IntArray {
    val set = mutableSetOf<String>()
    val map = mutableMapOf<String, Int>()

    for (gem in gems) {
        set.add(gem)
    }

    val size = set.size
    var start = 0
    var end = 0
    var rs = 0
    var re = 0

    while (map.size != size) {
        map[gems[end]] = (map[gems[end]] ?: 0) + 1
        end++
    }
    re = end

    while (end <= gems.size) {
        if (map.size == size) {
            while (map[gems[start]]!! > 1) {
                if (map[gems[start]]!! == 1) {
                    break
                } else {
                    map[gems[start]] = map[gems[start]]!! - 1
                }
                start++
                re = end
                rs = start
            }
        }
        if (end == gems.size)
            break
        map[gems[end]] = map.getOrDefault(gems[end], 0) + 1
        end++
        if (map[gems[start]]!! == 1)
            map.remove(gems[start])
        else
            map[gems[start]] = map[gems[start]]!! - 1
        start++
    }

    return intArrayOf(rs + 1, re)
}