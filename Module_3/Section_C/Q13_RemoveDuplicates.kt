// Program to remove duplicates from a list
fun main() {
    val originalList = listOf(10, 20, 30, 20, 40, 10, 50, 30, 60)

    println("Original List: $originalList")

    // Method 1: Using distinct() function
    val uniqueList = originalList.distinct()

    // Method 2: Manual approach using a loop (for learning concept)
    val manualUniqueList = mutableListOf<Int>()
    for (item in originalList) {
        if (!manualUniqueList.contains(item)) {
            manualUniqueList.add(item)
        }
    }

    println("List after removing duplicates: $uniqueList")
    println("Manually filtered unique list: $manualUniqueList")
}
