// BankAccount demonstrating encapsulation
class BankAccount(val accountNumber: String, initialBalance: Double = 0.0) {
    // Private balance variable to restrict direct access
    private var balance: Double = if (initialBalance >= 0) initialBalance else 0.0

    // Deposit function
    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Successfully deposited $$amount. New balance: $$balance")
        } else {
            println("Deposit amount must be positive.")
        }
    }

    // Withdraw function ensuring balance cannot become negative
    fun withdraw(amount: Double) {
        if (amount <= 0) {
            println("Withdrawal amount must be greater than zero.")
        } else if (amount > balance) {
            println("Insufficient funds! Cannot withdraw $$amount. Current balance: $$balance")
        } else {
            balance -= amount
            println("Successfully withdrew $$amount. Remaining balance: $$balance")
        }
    }

    // Getter function to view balance
    fun getBalance(): Double {
        return balance
    }
}

fun main() {
    val account = BankAccount("ACC-98765", 1000.0)

    println("Account Number: ${account.accountNumber}")
    println("Initial Balance: $${account.getBalance()}\n")

    account.deposit(500.0)
    account.withdraw(300.0)
    account.withdraw(1500.0) // Exceeds balance test

    println("\nFinal Balance: $${account.getBalance()}")
}
