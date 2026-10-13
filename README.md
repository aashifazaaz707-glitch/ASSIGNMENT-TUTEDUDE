# Kotlin Course Assignments (Tutedude)

Repository containing completed assignments for Tutedude Kotlin course:
- **Module 3:** Kotlin Basics Practice (Conditionals, Functions, Arrays, Lists)
- **Module 4:** Object-Oriented Programming (OOP) in Kotlin
- **EcommerceApp:** Full E-Commerce Platform Android Application (MVVM, Jetpack Compose, Room, Hilt, Firebase, FakeStore API)

---

## Repository Structure

```text
├── EcommerceApp/                 # Complete Android Studio project (MVVM, Compose, Room, Hilt, Firebase)

├── Module_3/
│   ├── Section_A/
│   │   ├── Q1_EvenOrOdd.kt
│   │   ├── Q2_LargestOfThree.kt
│   │   ├── Q3_MultiplicationTable.kt
│   │   ├── Q4_CountVowels.kt
│   │   └── Q5_ReverseString.kt
│   ├── Section_B/
│   │   ├── Q6_GradeCalculator.kt
│   │   ├── Q7_SimpleCalculator.kt
│   │   ├── Q8_PalindromeCheck.kt
│   │   ├── Q9_MenuOperations.kt
│   │   └── Q10_Factorial.kt
│   └── Section_C/
│       ├── Q11_ArraySum.kt
│       ├── Q12_ListMaxElement.kt
│       ├── Q13_RemoveDuplicates.kt
│       ├── Q14_ElementFrequency.kt
│       └── Q15_SecondLargest.kt
│
├── Module_4/
│   ├── Section_A/
│   │   ├── Q1_CarDetails.kt
│   │   ├── Q2_StudentClass.kt
│   │   └── Q3_RectangleArea.kt
│   ├── Section_B/
│   │   ├── Q4_BankAccount.kt
│   │   └── Q5_EmployeeSalary.kt
│   ├── Section_C/
│   │   ├── Q6_AnimalDog.kt
│   │   └── Q7_PersonHierarchy.kt
│   ├── Section_D/
│   │   ├── Q8_PlayableInterface.kt
│   │   └── Q9_ShapeInterface.kt
│   ├── Section_E/
│   │   ├── Q10_ShapePolymorphism.kt
│   │   └── Q11_AnimalSoundPolymorphism.kt
│   └── Mini_Assignment/
│       └── LibrarySystem.kt
│
├── .gitignore
└── README.md
```

---

## Module 3: Kotlin Basics Practice

### Section A: Basic Practice
- **Q1_EvenOrOdd.kt**: Checks whether a number is even or odd using the `% 2 == 0` check.
- **Q2_LargestOfThree.kt**: Defines `findLargest(a, b, c)` to find the largest of three numbers using conditionals.
- **Q3_MultiplicationTable.kt**: Prints the multiplication table of a given number from 1 to 10.
- **Q4_CountVowels.kt**: Counts vowels (`a, e, i, o, u`) in an input string.
- **Q5_ReverseString.kt**: Reverses a given string using a dedicated function.

### Section B: Conditionals and Functions
- **Q6_GradeCalculator.kt**: Computes grade based on marks using Kotlin's `when` expression.
- **Q7_SimpleCalculator.kt**: Basic calculator using functions: `add`, `subtract`, `multiply`, and `divide`.
- **Q8_PalindromeCheck.kt**: Checks if an integer is a palindrome by reversing digits mathematically.
- **Q9_MenuOperations.kt**: Menu-driven program using `when` for arithmetic and power operations.
- **Q10_Factorial.kt**: Computes factorial using a loop and `Long` return type.

### Section C: Arrays and Lists
- **Q11_ArraySum.kt**: Computes the sum of elements in an array.
- **Q12_ListMaxElement.kt**: Finds the maximum element in a list.
- **Q13_RemoveDuplicates.kt**: Removes duplicate elements using `distinct()` and a manual algorithm.
- **Q14_ElementFrequency.kt**: Counts frequency of each element in a list using a map.
- **Q15_SecondLargest.kt**: Identifies the second largest unique value in a list.

---

## Module 4: OOPs in Kotlin

### Section A: Basic OOP Practice
- **Q1_CarDetails.kt**: Defines class `Car` with `brand`, `model`, and `price`. Creates 3 objects and prints their details.
- **Q2_StudentClass.kt**: Defines class `Student` with `name` and `rollNumber`, along with an `introduce()` member function.
- **Q3_RectangleArea.kt**: Defines class `Rectangle` with `length` and `breadth`, and an `area()` calculation function.

### Section B: Encapsulation
- **Q4_BankAccount.kt**: Defines class `BankAccount` with `private var balance`, validating `deposit()` and `withdraw()` so balance never goes negative, with `getBalance()`.
- **Q5_EmployeeSalary.kt**: Defines class `Employee` with private salary and custom getter/setter with non-negative validation.

### Section C: Inheritance
- **Q6_AnimalDog.kt**: `open class Animal` with `eat()` and `sleep()`, extended by derived class `Dog` with `bark()`.
- **Q7_PersonHierarchy.kt**: Base `open class Person` inherited by `Teacher` and `StudentPerson` classes with overridden details.

### Section D: Interfaces
- **Q8_PlayableInterface.kt**: Interface `Playable` with method `play()`, implemented by `Cricket` and `Football`.
- **Q9_ShapeInterface.kt**: Interface `Shape` with method `area()`, implemented by `CircleShape` and `RectangleShape`.

### Section E: Polymorphism
- **Q10_ShapePolymorphism.kt**: Base class `Shape` with `area()` overridden by `Circle` and `RectanglePoly`. Stores objects in a `List<Shape>` and calls `area()` polymorphically.
- **Q11_AnimalSoundPolymorphism.kt**: Base class `AnimalSound` with `makeSound()` overridden by `DogSound`, `CatSound`, and `CowSound`, called dynamically in a `List<AnimalSound>`.

### Mini Assignment: Library Management System
- **LibrarySystem.kt**: Complete OOP system with:
  - Class `Book` (`title`, `author`)
  - Class `Library` (encapsulated `private val books: MutableList<Book>`)
  - Methods: `addBook()`, `removeBook()`, `showBooks()`, and `getTotalBooks()`

---

## How to Run

### Using IntelliJ IDEA / Android Studio:
1. Open this repository in IntelliJ IDEA or Android Studio.
2. Navigate to any file (e.g., `Module_4/Mini_Assignment/LibrarySystem.kt`).
3. Click the green **Run** arrow next to `fun main()` to execute.
