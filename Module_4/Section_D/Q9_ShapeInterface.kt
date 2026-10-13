// Interface Shape
interface Shape {
    fun area(): Double
}

// Circle implementing Shape interface
class CircleShape(val radius: Double) : Shape {
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}

// Rectangle implementing Shape interface
class RectangleShape(val length: Double, val breadth: Double) : Shape {
    override fun area(): Double {
        return length * breadth
    }
}

fun main() {
    val circle: Shape = CircleShape(5.0)
    val rectangle: Shape = RectangleShape(6.0, 4.0)

    println("Circle Area (radius 5.0): %.2f".format(circle.area()))
    println("Rectangle Area (6.0 x 4.0): %.2f".format(rectangle.area()))
}
