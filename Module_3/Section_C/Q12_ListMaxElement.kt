// Program to find the maximum element in a list
fun main() {
    val numbers = listOf(14, 82, 35, 99, 41, 7, 63)

    println("Original List: $numbers")

    if (numbers.isEmpty()) {
        println("The list is empty.")
        return
    }

    var max = numbers[0]
    for (num in numbers) {
        if (num > max) {
            max = num
        }
    }

    println("The maximum element in the list is: $max")
}
