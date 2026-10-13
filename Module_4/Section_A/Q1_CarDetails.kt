// Class Car with brand, model, and price properties
class Car(val brand: String, val model: String, val price: Double) {
    fun displayDetails() {
        println("Brand: $brand | Model: $model | Price: $$price")
    }
}

fun main() {
    // Creating 3 Car objects
    val car1 = Car("Toyota", "Corolla", 22000.0)
    val car2 = Car("Tesla", "Model 3", 38990.0)
    val car3 = Car("BMW", "X5", 65500.0)

    println("--- Car Details ---")
    car1.displayDetails()
    car2.displayDetails()
    car3.displayDetails()
}
