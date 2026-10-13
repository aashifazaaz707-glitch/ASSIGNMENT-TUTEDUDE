import java.util.Scanner

// Function to find the largest of three numbers
fun findLargest(a: Int, b: Int, c: Int): Int {
    return if (a >= b && a >= c) {
        a
    } else if (b >= a && b >= c) {
        b
    } else {
        c
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    println("Enter three numbers:")
    print("First number: ")
    val num1 = scanner.nextInt()

    print("Second number: ")
    val num2 = scanner.nextInt()

    print("Third number: ")
    val num3 = scanner.nextInt()

    val largest = findLargest(num1, num2, num3)
    println("The largest number among $num1, $num2, and $num3 is: $largest")
}
