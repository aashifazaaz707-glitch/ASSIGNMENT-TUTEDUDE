import java.util.Scanner

// Function to reverse a string
fun reverseString(text: String): String {
    var reversed = ""
    for (i in text.length - 1 downTo 0) {
        reversed += text[i]
    }
    return reversed
}

fun main() {
    val scanner = Scanner(System.`in`)

    print("Enter a string to reverse: ")
    val original = scanner.nextLine()

    val result = reverseString(original)
    println("Original String: $original")
    println("Reversed String: $result")
}
