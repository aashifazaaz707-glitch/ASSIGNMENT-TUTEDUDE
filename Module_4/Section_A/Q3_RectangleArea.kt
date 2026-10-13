// Class Rectangle to calculate area
class Rectangle(val length: Double, val breadth: Double) {
    fun area(): Double {
        return length * breadth
    }
}

fun main() {
    val rect1 = Rectangle(10.5, 5.0)
    val rect2 = Rectangle(7.0, 3.5)

    println("Rectangle 1 (Length: ${rect1.length}, Breadth: ${rect1.breadth}) -> Area: ${rect1.area()}")
    println("Rectangle 2 (Length: ${rect2.length}, Breadth: ${rect2.breadth}) -> Area: ${rect2.area()}")
}
