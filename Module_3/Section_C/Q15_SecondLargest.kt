// Program to find the second largest element in a list
fun findSecondLargest(list: List<Int>): Int? {
    if (list.size < 2) {
        return null
    }

    var largest = Int.MIN_VALUE
    var secondLargest = Int.MIN_VALUE

    for (num in list) {
        if (num > largest) {
            secondLargest = largest
            largest = num
        } else if (num > secondLargest && num != largest) {
            secondLargest = num
        }
    }

    return if (secondLargest == Int.MIN_VALUE) null else secondLargest
}

fun main() {
    val numbers = listOf(45, 12, 89, 70, 23, 89, 34)

    println("List: $numbers")

    val secondLargest = findSecondLargest(numbers)

    if (secondLargest != null) {
        println("The second largest element is: $secondLargest")
    } else {
        println("There is no distinct second largest element in the list.")
    }
}
