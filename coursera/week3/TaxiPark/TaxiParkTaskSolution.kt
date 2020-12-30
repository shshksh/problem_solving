package taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDriversS(): Set<Driver> = allDrivers - trips.map { it.driver }
/*
allDrivers.filter { d -> trips.none { it.driver == d } }.toSet()
allDrivers.minus(trips.map { it.driver }) - can convert to '-' operator
 */

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengersS(minTrips: Int): Set<Passenger> {
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
// start with trips
//        trips
//                .flatMap { it.passengers }
//                .groupBy { it }
//                .filter { it.value.size >= minTrips }
//                .map { it.key }
//                .toSet()
// improved
//        trips
//                .flatMap(Trip::passengers)
//                .groupBy { passenger -> passenger }
//                .filterValues { group -> group.size >= minTrips }
//                .keys

// start with allPassengers
//allPassengers
//        .partition { p ->
//            trips.sumBy { t ->
//                if (p in t.passengers) 1 else 0
//            } >= minTrips
//        }
//        .first
//        .toSet()
// improved
//        allPassengers
//                .filter { p ->
//                    trips.count { p in it.passengers } >= minTrips
//                }
//                .toSet()

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengersS(driver: Driver): Set<Passenger> {
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
// start with trips
//        trips
//                .filter { trip -> trip.driver == driver }
//                .flatMap(Trip::passengers)
//                .groupBy { passenger -> passenger }
//                .filterValues { group -> group.size > 1 }
//                .keys
// start with allPassengers
//        allPassengers
//                .filter { p ->
//                    trips.count { it.driver == driver && p in it.passengers } > 1
//                }
//                .toSet()


/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengersS(): Set<Passenger> {
    val map = allPassengers.associateWith { mutableListOf(0, 0) }
    val pair = trips.partition { it.discount != null }
    pair.first.map { it.passengers }.flatten().forEach { map[it]!![0] += 1 }
    pair.second.map { it.passengers }.flatten().forEach { map[it]!![1] += 1 }
    return map.filter { (_, value) -> value[0] > value[1] }.keys
}
//{
//    val pair = trips.partition { it.discount is Double }
//    return allPassengers
//            .filter { passenger ->
//                pair.first.count { it.passengers.contains(passenger) } >
//                        pair.second.count { it.passengers.contains(passenger) }
//            }
//            .toSet()
//    improved
//    val (tripsWithDiscount, tripsWithoutDiscount) =
//            trips.partition { it.discount is Double }
//    return allPassengers
//            .filter { passenger ->
//                tripsWithDiscount.count { passenger in it.passengers } >
//                        tripsWithoutDiscount.count { passenger in it.passengers }
//            }
//            .toSet()
//}

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriodS(): IntRange? {
//    val map = trips
//            .map { it.duration }
//            .groupBy { (it / 10) * 10 until (it / 10 + 1) * 10 }
//    return map.maxBy { it.value.size }?.key
    return trips
            .groupBy {
                val start = it.duration / 10 * 10
                val end = start + 9
                start..end
            }
            .maxBy { (_, group) -> group.size }
            ?.key
}




/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
/*
fun TaxiPark.checkParetoPrincipleS(): Boolean {
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
*/
