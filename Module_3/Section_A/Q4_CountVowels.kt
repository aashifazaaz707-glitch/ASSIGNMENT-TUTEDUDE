import java.util.Scanner

// Program to count the number of vowels in a string
fun main() {
    val scanner = Scanner(System.`in`)

    print("Enter a string: ")
    val input = scanner.nextLine()

    var vowelCount = 0

    for (ch in input) {
        val lowerChar = ch.lowercaseChar()
        if (lowerChar == 'a' || lowerChar == 'e' || lowerChar == 'i' || lowerChar == 'o' || lowerChar == 'u') {
            vowelCount++
        }
    }

    println("Number of vowels in \"$input\": $vowelCount")
}
