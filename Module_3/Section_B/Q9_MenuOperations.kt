import java.util.Scanner

// Menu-driven program using 'when' for math operations
fun main() {
    val scanner = Scanner(System.`in`)

    while (true) {
        println("\n===== MATH OPERATIONS MENU =====")
        println("1. Addition")
        println("2. Subtraction")
        println("3. Multiplication")
        println("4. Division")
        println("5. Modulus (Remainder)")
        println("6. Power (a^b)")
        println("7. Exit")
        print("Choose an option (1-7): ")

        val choice = scanner.nextInt()

        if (choice == 7) {
            println("Exiting program. Goodbye!")
            break
        }

        print("Enter first number: ")
        val num1 = scanner.nextDouble()

        print("Enter second number: ")
        val num2 = scanner.nextDouble()

        when (choice) {
            1 -> println("Result: $num1 + $num2 = ${num1 + num2}")
            2 -> println("Result: $num1 - $num2 = ${num1 - num2}")
            3 -> println("Result: $num1 * $num2 = ${num1 * num2}")
            4 -> {
                if (num2 != 0.0) {
                    println("Result: $num1 / $num2 = ${num1 / num2}")
                } else {
                    println("Error: Cannot divide by zero.")
                }
            }
            5 -> {
                if (num2 != 0.0) {
                    println("Result: $num1 % $num2 = ${num1 % num2}")
                } else {
                    println("Error: Cannot modulo by zero.")
                }
            }
            6 -> {
                val power = Math.pow(num1, num2)
                println("Result: $num1 ^ $num2 = $power")
            }
            else -> println("Invalid option! Please select a valid number from the menu.")
        }
    }
}
