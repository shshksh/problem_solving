package codinginterview.algorithm.greedy

//fun maxProfit(prices: IntArray): Int {
//    return prices.zip(prices.sliceArray(1 until prices.size))
//        .filter { it.first < it.second }
//        .sumBy { it.second - it.first }
//}

fun maxProfit(prices: IntArray): Int {
    var result = 0
    for (i in 1 until prices.size) {
        if (prices[i] > prices[i - 1])
            result += prices[i] - prices[i-1]
    }
    return result
}