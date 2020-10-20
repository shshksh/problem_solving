package taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
        allDrivers - trips.map { it.driver }

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> {
    val map = allPassengers
            .associateWith { 0 }
            .toMutableMap()
    trips.forEach { trip: Trip ->
        trip.passengers.forEach { passenger: Passenger ->
            map[passenger] = map.getOrDefault(passenger, 0) + 1
        }
    }
    return map.filter { it.value >= minTrips }.keys
}

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> {
    val list = trips
            .filter { it.driver == driver }
            .map { it.passengers }
            .flatten()
            .toMutableList()
    for (passenger in allPassengers) {
        list.remove(passenger)
    }
    return list.toSet()
}

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> {
    val map = allPassengers.associateWith { mutableListOf(0, 0) }
    val pair = trips.partition { it.discount != null }
    pair.first.map { it.passengers }.flatten().forEach { map[it]!![0] += 1 }
    pair.second.map { it.passengers }.flatten().forEach { map[it]!![1] += 1 }
    return map.filter { (_, value) -> value[0] > value[1] }.keys
}

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    val map = trips
            .map { it.duration }
            .groupBy { (it / 10) * 10 until (it / 10 + 1) * 10 }
    return map.maxBy { it.value.size }?.key
}


/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    val topDriverCnt: Int = (allDrivers.size * 0.2).toInt()
    val list = trips
            .map { it.driver to it.cost }
            .groupBy { it.first }
            .map { it.key to it.value.sumByDouble { pair -> pair.second } }
    if (list.isEmpty())
        return false
    val sum = list.sumByDouble { it.second }
    val topSum = list.sortedByDescending { it.second }.subList(0, topDriverCnt).sumByDouble { it.second }
    return topSum >= sum * 0.8
}