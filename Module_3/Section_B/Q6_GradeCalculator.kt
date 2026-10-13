import java.util.Scanner

// Grade calculator using 'when' expression
fun main() {
    val scanner = Scanner(System.`in`)

    print("Enter student marks (0 - 100): ")
    val marks = scanner.nextInt()

    val grade = when (marks) {
        in 90..100 -> "A+ (Outstanding)"
        in 80..89 -> "A (Excellent)"
        in 70..79 -> "B (Very Good)"
        in 60..69 -> "C (Good)"
        in 50..59 -> "D (Pass)"
        in 0..49 -> "F (Fail)"
        else -> "Invalid marks! Marks must be between 0 and 100."
    }

    println("Marks: $marks")
    println("Grade: $grade")
}
