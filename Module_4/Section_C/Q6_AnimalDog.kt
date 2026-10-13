// Base class Animal (marked 'open' to allow inheritance)
open class Animal(val name: String) {
    fun eat() {
        println("$name is eating.")
    }

    fun sleep() {
        println("$name is sleeping.")
    }
}

// Derived class Dog inheriting from Animal
class Dog(name: String, val breed: String) : Animal(name) {
    fun bark() {
        println("$name the $breed is barking: Woof! Woof!")
    }
}

fun main() {
    val myDog = Dog("Buddy", "Golden Retriever")

    // Calling inherited functions from Animal
    myDog.eat()
    myDog.sleep()

    // Calling Dog's specific function
    myDog.bark()
}
