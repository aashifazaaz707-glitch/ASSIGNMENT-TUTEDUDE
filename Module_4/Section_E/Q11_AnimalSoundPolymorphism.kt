// Base class Animal
open class AnimalSound(val name: String) {
    open fun makeSound() {
        println("$name makes a generic animal sound.")
    }
}

// Derived class Dog
class DogSound(name: String) : AnimalSound(name) {
    override fun makeSound() {
        println("$name says: Woof! Woof!")
    }
}

// Derived class Cat
class CatSound(name: String) : AnimalSound(name) {
    override fun makeSound() {
        println("$name says: Meow! Meow!")
    }
}

// Derived class Cow
class CowSound(name: String) : AnimalSound(name) {
    override fun makeSound() {
        println("$name says: Moo! Moo!")
    }
}

fun main() {
    // List of AnimalSound base class containing different animal objects
    val animals: List<AnimalSound> = listOf(
        DogSound("Tommy"),
        CatSound("Kitty"),
        CowSound("Daisy"),
        DogSound("Rocky")
    )

    println("--- Animal Sounds (Polymorphism in Action) ---")
    for (animal in animals) {
        animal.makeSound()
    }
}
