// Class Student with name and rollNumber
class Student(val name: String, val rollNumber: Int) {
    fun introduce() {
        println("Hello, my name is $name and my roll number is $rollNumber.")
    }
}

fun main() {
    val student1 = Student("Aman Sharma", 101)
    val student2 = Student("Priya Singh", 102)

    student1.introduce()
    student2.introduce()
}
