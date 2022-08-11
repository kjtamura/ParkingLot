fun main() {

    val parkingLot = ParkingLot(20)

    do {
        val input = readln().split(" ")
        when (input[0]) {
            "park" -> {
                val car = Car(input[1], input[2])
                car.park(parkingLot)
            }
            "leave" -> parkingLot.leave(input[1].toInt())
            "exit" -> break
        }
    } while (true)
}
