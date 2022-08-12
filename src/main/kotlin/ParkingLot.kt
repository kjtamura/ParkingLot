class Spot() {
    private var car: Car? = null
    private var spotNum = 0

    fun set(_car: Car) {
        car = _car
    }

    fun empty() {
        car = null
    }

    fun occupied(): Car? {
        return car
    }

    fun getSpotNum(): Int {
        return spotNum
    }

    fun setSpotNum(num: Int) {
        spotNum = num
    }

}
class ParkingLot(size: Int = 0) {
    private val parkingSpots = MutableList<Spot?>(size) { null }

    fun build(size: Int) {
        clear()
        for (i in 1..size) {
            parkingSpots.add(Spot())
            parkingSpots.last()?.setSpotNum(i)
        }
    }

    fun empty(): Boolean {
        return parkingSpots.isEmpty()
    }

    fun clear() {
        parkingSpots.clear()
    }

    fun park(car: Car) {
        val spot = parkingSpots.find({ it?.occupied() == null })
        when (spot) {
            null -> println("Sorry, the parking lot is full.")
            else -> {
                spot.set(car)
                println("${car.color} car parked in spot ${spot.getSpotNum()}.")
            }
        }
    }

    fun leave(spotNum: Int) {
        val spot = parkingSpots[spotNum - 1]
        when (spot?.occupied()) {
            null -> println("There is no car in spot ${spot?.getSpotNum()}.")
            else -> {
                spot.empty()
                println("Spot ${spot.getSpotNum()} is free.")
            }
        }
    }

    fun status() {
        val found = parkingSpots.find { it?.occupied() != null }
        if (found == null) {
            println("Parking lot is empty.")
        } else {
            for (spot in parkingSpots) {
                val car = spot?.occupied()
                if (car != null) {
                    print("${spot.getSpotNum()} ")
                    car.printCarInfo()
                }
            }
        }
    }
}