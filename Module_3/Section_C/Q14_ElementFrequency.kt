// Program to count the frequency of each element in a list
fun main() {
    val items = listOf("apple", "banana", "apple", "orange", "banana", "apple", "mango")

    println("Original List: $items")

    // Map to store item -> count
    val frequencyMap = mutableMapOf<String, Int>()

    for (item in items) {
        val currentCount = frequencyMap[item] ?: 0
        frequencyMap[item] = currentCount + 1
    }

    println("\nElement Frequencies:")
    for ((element, count) in frequencyMap) {
        println("$element : $count time(s)")
    }
}
