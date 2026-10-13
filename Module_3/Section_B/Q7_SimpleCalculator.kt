import java.util.Scanner

// Calculator functions
fun add(a: Double, b: Double): Double = a + b

fun subtract(a: Double, b: Double): Double = a - b

fun multiply(a: Double, b: Double): Double = a * b

fun divide(a: Double, b: Double): Double {
    if (b == 0.0) {
        println("Error: Division by zero is not allowed.")
        return Double.NaN
    }
    return a / b
}

fun main() {
    val scanner = Scanner(System.`in`)

    print("Enter first number: ")
    val num1 = scanner.nextDouble()

    print("Enter operator (+, -, *, /): ")
    val op = scanner.next()[0]

    print("Enter second number: ")
    val num2 = scanner.nextDouble()

    when (op) {
        '+' -> println("Result: $num1 + $num2 = ${add(num1, num2)}")
        '-' -> println("Result: $num1 - $num2 = ${subtract(num1, num2)}")
        '*' -> println("Result: $num1 * $num2 = ${multiply(num1, num2)}")
        '/' -> {
            val res = divide(num1, num2)
            if (!res.isNaN()) {
                println("Result: $num1 / $num2 = $res")
            }
        }
        else -> println("Invalid operator! Please enter +, -, *, or /")
    }
}
