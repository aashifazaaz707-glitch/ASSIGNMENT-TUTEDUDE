// Book class representing a book with title and author
data class Book(val title: String, val author: String) {
    fun displayBook() {
        println("  • \"$title\" by $author")
    }
}

// Library class using encapsulation to manage collection of books
class Library(val libraryName: String) {
    // Encapsulated private list of books to prevent direct external modification
    private val books = mutableListOf<Book>()

    // Function to add a book to the library
    fun addBook(book: Book) {
        books.add(book)
        println("Added: \"${book.title}\" by ${book.author}")
    }

    // Function to remove a book by title
    fun removeBook(title: String): Boolean {
        val foundBook = books.find { it.title.equals(title, ignoreCase = true) }
        return if (foundBook != null) {
            books.remove(foundBook)
            println("Removed: \"${foundBook.title}\" from $libraryName.")
            true
        } else {
            println("Book \"$title\" not found in $libraryName.")
            false
        }
    }

    // Function to display all available books in the library
    fun showBooks() {
        println("\n=== Books in $libraryName (${books.size} total) ===")
        if (books.isEmpty()) {
            println("  No books currently available in the library.")
        } else {
            for (book in books) {
                book.displayBook()
            }
        }
        println("=========================================\n")
    }

    // Getter to check total count of books safely
    fun getTotalBooks(): Int = books.size
}

fun main() {
    val library = Library("City Central Library")

    // Adding books
    library.addBook(Book("Clean Code", "Robert C. Martin"))
    library.addBook(Book("Kotlin in Action", "Dmitry Jemerov & Svetlana Isakova"))
    library.addBook(Book("The Pragmatic Programmer", "Andy Hunt & Dave Thomas"))
    library.addBook(Book("Head First Java", "Kathy Sierra & Bert Bates"))

    // Displaying books
    library.showBooks()

    // Removing an existing book
    library.removeBook("Clean Code")

    // Trying to remove a book not present
    library.removeBook("Atomic Habits")

    // Showing updated list
    library.showBooks()
}
