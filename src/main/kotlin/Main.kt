enum class ParkingLotActions (val action: String) {
    CREATE("create"),
    STATUS("status"),
    PARK("park"),
    LEAVE("leave"),
    EXIT("exit")
}

val parkingLot = ParkingLot()
fun create(input: List<String>) {
    parkingLot.build(input[1].toInt())
    println("Created a parking lot with ${input[1]} spots.")
}

fun status () {
    if (parkingLot.empty()) {
        emptyParkingLotMsg()
    } else {
        parkingLot.status()
    }
}

fun action  (input: List<String>) {
    if (parkingLot.empty()) {
        emptyParkingLotMsg()
    } else {
        val car = Car(input[1], input[2])
        car.park(parkingLot)
    }
}

fun leave  (input: List<String>) {
    if(parkingLot.empty()) {
        emptyParkingLotMsg()
    } else {
        parkingLot.leave(input[1].toInt())
    }
}
fun main() {
    do {
        val input = readln().split(" ")
        when (input[0]) {
            ParkingLotActions.CREATE.action-> create(input)
            ParkingLotActions.STATUS.action -> status()
            ParkingLotActions.PARK.action -> action(input)
            ParkingLotActions.LEAVE.action -> leave(input)
            ParkingLotActions.EXIT.action -> break
        }
    } while (true)
}

fun emptyParkingLotMsg() {
    println("Sorry, a parking lot has not been created.")
}