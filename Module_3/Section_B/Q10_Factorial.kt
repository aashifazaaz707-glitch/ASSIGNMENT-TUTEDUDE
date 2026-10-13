import java.util.Scanner

// Function to calculate factorial of a non-negative integer
fun factorial(n: Int): Long {
    if (n < 0) {
        println("Factorial is not defined for negative numbers.")
        return -1
    }

    var result = 1L
    for (i in 1..n) {
        result *= i
    }
    return result
}

fun main() {
    val scanner = Scanner(System.`in`)

    print("Enter a number to find its factorial: ")
    val num = scanner.nextInt()

    val fact = factorial(num)
    if (fact != -1L) {
        println("Factorial of $num ($num!) is: $fact")
    }
}
