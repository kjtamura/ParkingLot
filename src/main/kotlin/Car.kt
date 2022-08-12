class Car (_registrationNum: String = "", _color: String = ""){

    val registrationNum = _registrationNum
    val color = _color
    fun park(parkingLot: ParkingLot) {
        parkingLot.park(this)
    }

    fun leave(parkingLot: ParkingLot, spot: Int) {
        parkingLot.leave(spot)
    }

    fun printCarInfo() {
        println("${this.registrationNum} ${this.color}")
    }
}