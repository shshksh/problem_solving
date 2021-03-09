package codinginterview.algorithm.greedy

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    val diff = IntArray(gas.size)
    val acc = IntArray(gas.size)
    for (index in gas.indices) {
        diff[index] = gas[index] - cost[index]
        acc[index] = gas[index] - cost[index]
        if (index > 0) {
            acc[index] += acc[index - 1]
        }
    }

    if (acc[gas.size - 1] < 0) {
        return -1
    }

    var head = 0
    var tail = 0
    var sum = diff[head]

    while (tail < diff.size) {
        if (sum < 0) {
            head = tail + 1
            tail++
            sum = diff[head]
        } else {
            tail++
            sum += diff[tail % diff.size]
        }
    }

    return head
}