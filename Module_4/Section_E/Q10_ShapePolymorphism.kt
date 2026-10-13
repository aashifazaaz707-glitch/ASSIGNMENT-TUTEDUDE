// Base class Shape demonstrating runtime polymorphism
open class Shape {
    open fun area(): Double {
        return 0.0
    }
}

// Derived class Circle
class Circle(val radius: Double) : Shape() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}

// Derived class Rectangle
class RectanglePoly(val length: Double, val width: Double) : Shape() {
    override fun area(): Double {
        return length * width
    }
}

fun main() {
    // Storing derived objects in a List of base class Shape
    val shapes: List<Shape> = listOf(
        Circle(7.0),
        RectanglePoly(8.0, 5.0),
        Circle(3.5),
        RectanglePoly(12.0, 6.0)
    )

    println("--- Polymorphic Shape Area Calculation ---")
    for ((index, shape) in shapes.withIndex()) {
        val shapeType = shape.javaClass.simpleName
        println("Shape #${index + 1} ($shapeType) Area: %.2f".format(shape.area()))
    }
}
