import java.util.Scanner

// Function to check if a number is a palindrome
fun isPalindrome(number: Int): Boolean {
    // Negative numbers are not palindromes
    if (number < 0) return false

    var original = number
    var reversed = 0

    while (original > 0) {
        val digit = original % 10
        reversed = (reversed * 10) + digit
        original /= 10
    }

    return reversed == number
}

fun main() {
    val scanner = Scanner(System.`in`)

    print("Enter a number to check palindrome: ")
    val num = scanner.nextInt()

    if (isPalindrome(num)) {
        println("$num is a Palindrome number.")
    } else {
        println("$num is NOT a Palindrome number.")
    }
}
