import java.util.Scanner

// Program to print the multiplication table of a given number
fun main() {
    val scanner = Scanner(System.`in`)

    print("Enter a number to print its multiplication table: ")
    val num = scanner.nextInt()

    println("--- Multiplication Table of $num ---")
    for (i in 1..10) {
        println("$num x $i = ${num * i}")
    }
}
