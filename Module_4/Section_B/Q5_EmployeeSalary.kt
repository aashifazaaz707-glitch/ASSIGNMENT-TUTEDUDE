// Employee class with private salary and custom getter/setter validation
class Employee(val empId: Int, val name: String) {
    // Private salary variable
    private var salary: Double = 0.0

    // Setter with validation
    fun setSalary(amount: Double) {
        if (amount >= 0.0) {
            salary = amount
            println("Salary updated successfully to $$salary for $name.")
        } else {
            println("Invalid salary: $$amount. Salary cannot be negative.")
        }
    }

    // Getter function
    fun getSalary(): Double {
        return salary
    }
}

fun main() {
    val emp = Employee(201, "Rahul Verma")

    println("Employee ID: ${emp.empId}, Name: ${emp.name}")
    
    // Setting valid salary
    emp.setSalary(45000.0)
    println("Current Salary: $${emp.getSalary()}\n")

    // Attempting invalid negative salary
    emp.setSalary(-5000.0)
    println("Current Salary after invalid attempt: $${emp.getSalary()}")
}
