// Base class Person
open class Person(val name: String, val age: Int) {
    open fun displayInfo() {
        println("Name: $name, Age: $age")
    }
}

// Derived class Teacher
class Teacher(name: String, age: Int, val subject: String) : Person(name, age) {
    fun teach() {
        println("$name is teaching $subject.")
    }

    override fun displayInfo() {
        println("Teacher -> Name: $name, Age: $age, Subject: $subject")
    }
}

// Derived class Student
class StudentPerson(name: String, age: Int, val grade: String) : Person(name, age) {
    fun study() {
        println("$name is studying in grade $grade.")
    }

    override fun displayInfo() {
        println("Student -> Name: $name, Age: $age, Grade: $grade")
    }
}

fun main() {
    val teacher = Teacher("Dr. Sharma", 45, "Mathematics")
    val student = StudentPerson("Rohan", 16, "11th")

    println("--- Teacher Info ---")
    teacher.displayInfo()
    teacher.teach()

    println("\n--- Student Info ---")
    student.displayInfo()
    student.study()
}
