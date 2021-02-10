package ua.kpi.comsys.ip8421_1_2

import kotlin.math.min

class CoordinatePS {

    constructor(direct: Direction = Direction.latitude, degr: Int = 0, min: UInt = 0u, sec: UInt = 0u){

        when(direct){
            Direction.longitude -> {
                if (degr < -180 || degr > 180) {
                    error("$degr is not a propitiate value, try value between -180 to 180")
                }
            }
            Direction.latitude -> {
                if (degr < -90 || degr > 90){
                    error("$degr is not a propitiate value, try value between -90 to 90")
                }
            }
        }

        if (min < 0u || min > 59u) error("Inappropriate value for minutes - $min")
        if (sec < 0u || sec > 59u) error("Inappropriate value for seconds - $sec")
        direction = direct
        degrees = degr
        minutes = min
        seconds = sec
    }

    var direction : Direction
    var degrees : Int
    var minutes : UInt
    var seconds : UInt

    private fun getDirectionName(direct: Direction, degr: Int) : String{
        return when(direct) {
            Direction.longitude -> {
                if (degr > 0) "N" else "S"
            }
            Direction.latitude -> {
                if (degr > 0) "E" else "W"
            }
        }
    }

    fun method1() : String {
        var directionName:String = getDirectionName(direction, degrees)
        return "$degrees°$minutes′$seconds″ $directionName"
    }

    fun method2() : String {
        var directionName:String = getDirectionName(direction, degrees)
        var coordinateDegree:String
        if( degrees > 0) {
            coordinateDegree = (degrees.toFloat() + seconds.toFloat() / 3600f + minutes.toFloat() / 60f).toString()
        } else {
            coordinateDegree = (degrees.toFloat() - seconds.toFloat() / 3600f - minutes.toFloat() / 60f).toString()
        }
        return "$coordinateDegree° $directionName"
    }

    fun method3(coord2: CoordinatePS) : CoordinatePS? {
        var coordFinal = CoordinatePS()
        if (this.direction != coord2.direction) return null
        coordFinal.degrees = (this.degrees + coord2.degrees )/2
        coordFinal.minutes = (this.minutes + coord2.minutes )/ 2u
        coordFinal.seconds = (this.seconds + coord2.seconds )/ 2u
        println("${coordFinal.degrees}  degrees")
        println("${coordFinal.minutes}  minutes")
        println("${coordFinal.seconds}  seconds")
        return coordFinal
    }

    fun method4(coord1: CoordinatePS, coord2: CoordinatePS) : CoordinatePS? {
        var coordFinal = CoordinatePS()
        if (this.direction != coord2.direction) return null
        coordFinal.degrees = (coord1.degrees + coord2.degrees )/2
        coordFinal.minutes = (coord1.minutes + coord2.minutes )/ 2u
        coordFinal.seconds = (coord1.seconds + coord2.seconds )/ 2u
        println("${coordFinal.degrees}  degrees")
        println("${coordFinal.minutes}  minutes")
        println("${coordFinal.seconds}  seconds")
        return coordFinal
    }
}

enum class Direction {
    latitude,
    longitude
}

fun main(args: Array<String>){

    var cord1 = CoordinatePS(Direction.longitude, 87, 59u, 16u)
    var cord2 = CoordinatePS()
    var cord3 = CoordinatePS(Direction.longitude, 80, 50u, 10u)

    println("Method 1")
    println(cord1.method1())
    println(cord2.method1())
    println()
    println("Method 2")
    println(cord1.method2())
    println(cord2.method2())
    println()
    println("Method 3")
    println(cord1.method3(cord3))
    println()
    println("Method 4")
    println(cord1.method4(cord1, cord3))


}
