enum class ParkingLotActions (val action: String) {
    CREATE("create"),
    STATUS("status"),
    PARK("park"),
    LEAVE("leave"),
    EXIT("exit"),
    SPOTBYCOLOR("spot_by_color"),
    SPOTBYREG("spot_by_reg"),
    REGBYCOLOR("reg_by_color")
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

fun spotByColor(input: List<String>) {

    val listOfSpots = parkingLot.find(color = input[1])
    if(parkingLot.empty()) {
        emptyParkingLotMsg()
    }
    else if (listOfSpots.isEmpty()) {
        println("No cars with color ${input[1]} were found.")
    } else {
        println(listOfSpots.map { it.getSpotNum() }.toMutableList().joinToString(", "))
    }
}

fun spotByReg(input: List<String>) {
    val reg = input[1]
    val listOfSpots = parkingLot.find(reg = reg)
    if(parkingLot.empty()) {
        emptyParkingLotMsg()
    }
    else if (listOfSpots.isEmpty()) {
        println("No cars with registration number ${input[1]} were found.")
    } else {
        println(listOfSpots.map { it.getSpotNum() }.toMutableList().joinToString(", "))
    }
}

fun regByColor(input: List<String>) {
    val listOfSpots = parkingLot.find(color = input[1])
    if(parkingLot.empty()) {
        emptyParkingLotMsg()
    }
    else if (listOfSpots.isEmpty()) {
        println("No cars with color ${input[1]} were found.")
    } else {
        println(listOfSpots.map { it.occupied()?.registrationNum }.toMutableList().joinToString(", "))
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
            ParkingLotActions.SPOTBYCOLOR.action -> spotByColor(input)
            ParkingLotActions.SPOTBYREG.action -> spotByReg(input)
            ParkingLotActions.REGBYCOLOR.action -> regByColor(input)
            ParkingLotActions.EXIT.action -> break
        }
    } while (true)
}

fun emptyParkingLotMsg() {
    println("Sorry, a parking lot has not been created.")
}