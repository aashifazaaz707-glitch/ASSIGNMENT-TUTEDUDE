import java.util.Scanner

// Program to find the sum of elements in an array
fun main() {
    val scanner = Scanner(System.`in`)

    print("Enter the size of the array: ")
    val size = scanner.nextInt()

    val numbers = IntArray(size)
    println("Enter $size elements:")
    for (i in 0 until size) {
        print("Element ${i + 1}: ")
        numbers[i] = scanner.nextInt()
    }

    // Calculating sum using a loop
    var sum = 0
    for (num in numbers) {
        sum += num
    }

    println("\nArray elements: ${numbers.joinToString(", ")}")
    println("Sum of array elements: $sum")
}
