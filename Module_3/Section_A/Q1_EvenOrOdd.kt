import java.util.Scanner

// Program to check whether a number is even or odd
fun main() {
    val scanner = Scanner(System.`in`)

    print("Enter a number: ")
    val number = scanner.nextInt()

    if (number % 2 == 0) {
        println("$number is an Even number.")
    } else {
        println("$number is an Odd number.")
    }
}
