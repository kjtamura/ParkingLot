class ParkingLot(size: Int) {
    private val spots = MutableList<Car?> ( size) { null }

    fun park(car: Car) {
        val spot = spots.indexOf(null)
        when (spot) {
            -1 -> println("Sorry, the parking lot is full.")
            else -> {
                spots[spot] = car
                println("${car.color} car parked in spot ${spot + 1}.")
            }
        }
    }

    fun leave(spot: Int) {
        when (spots[spot - 1]) {
            null -> println("There is no car in spot $spot.")
            else -> {
                spots[spot - 1] = null
                println("Spot $spot is free.")
            }
        }

    }
}