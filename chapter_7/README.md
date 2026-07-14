# 📚 Library Management System Challenge
## Attention: The problem statement for this exercise was written by ChatGPT.

> A comprehensive Java challenge focused on practicing Object-Oriented Programming, control flow, arrays, `ArrayList`, matrices, and algorithm implementation **without using concepts beyond Chapter 7 of _Big Java_**.

## 🎯 Objective

Develop a **console-based Library Management System** capable of registering books, managing loans and returns, storing ratings, searching for books, generating statistics, and maintaining an operation history.

The project should emphasize:

- Clean code
- Good object-oriented design
- Encapsulation
- Readability
- Organization
- Algorithmic thinking

---

# 📖 Functional Requirements

## 1. Book Class

Create a `Book` class responsible for representing a single book.

### Private attributes

```text
title
author
isbn
available
borrowCount
rating
```

### Public methods

```text
Book(...)
borrow()
returnBook()
rate(double score)
showInformation()
isAvailable()
getBorrowCount()
getRating()
```

### Business Rules

- Every new book starts as available.
- Ratings must be between **0** and **10**.
- A borrowed book cannot be borrowed again.
- A book can only be returned if it is currently borrowed.
- Every successful loan increments `borrowCount`.

---

# 📚 Book Storage

The application must support up to **100 books**.

Use an array of objects:

```java
final int MAX_BOOKS = 100;

Book[] books = new Book[MAX_BOOKS];
int bookCount = 0;
```

Only the first `bookCount` positions should be considered valid.

---

# 🖥️ Main Menu

The program must remain running until the user chooses to exit.

```text
=============================
LIBRARY MANAGEMENT SYSTEM

1 - Register Book
2 - List Books
3 - Borrow Book
4 - Return Book
5 - Rate Book
6 - Search Book
7 - Statistics
8 - Loan Matrix
9 - Exit

=============================
```

---

# 📥 Register Book

Request:

- Title
- Author
- ISBN

Create a new `Book` object and store it in the array.

Update:

```text
bookCount
```

---

# 📚 List Books

Display every registered book.

Each book must include:

- Title
- Author
- ISBN
- Availability
- Number of loans
- Rating

---

# 🔄 Borrow Book

The user informs the book title.

The system must perform a **linear search**.

### If the book exists

- Borrow it if available.
- Otherwise inform that it is already borrowed.

### If the book does not exist

Display:

```text
Book not found.
```

---

# 🔁 Return Book

Search the book by title.

If found:

```text
returnBook();
```

Otherwise:

```text
Book not found.
```

---

# ⭐ Rate Book

Search a book by title.

Request a rating.

Accept only values between:

```text
0.0 and 10.0
```

Invalid values must be rejected.

---

# 📊 Statistics

Generate the following information:

- Total registered books
- Total borrowed books
- Total available books
- Average rating
- Most borrowed book
- Highest-rated book
- Lowest-rated book

---

# 🔍 Search Book

Search by title using:

```java
equalsIgnoreCase()
```

If found, display every available piece of information about the book.

Otherwise:

```text
Book not found.
```

---

# 📝 Operation History

Maintain a history of every operation performed using:

```java
ArrayList<String> history = new ArrayList<>();
```

Register events such as:

```text
Book registered
Book borrowed
Book returned
Book rated
```

Display the history inside the **Statistics** option using a **for-each** loop.

---

# 📅 Loan Matrix

Create a matrix capable of storing how many loans occurred on each day.

```java
int[][] loans = new int[12][31];
```

Where:

- Rows represent months
- Columns represent days

Whenever a loan occurs, request:

- Month
- Day

Then register:

```java
loans[month][day]++;
```

Create a menu option that prints the entire matrix using nested loops.

---

# ⚙️ Technical Requirements

The solution **must** use the following Java features:

## Object-Oriented Programming

- Classes
- Objects
- Constructors
- Encapsulation
- Instance methods
- `this`

## Primitive Types

- `int`
- `double`
- `boolean`

## Input / Output

- `Scanner`
- `printf`

## Decision Structures

- `if`
- `else`
- `else if`

## Iteration

- `while`
- `for`
- Enhanced `for`

## Arrays

- Primitive arrays
- Arrays of objects
- Partially filled arrays
- Two-dimensional arrays

## Collections

- `ArrayList`
- `add()`
- `get()`
- `size()`

## Strings

- `equalsIgnoreCase()`

## Math

- `Math.max()` (or equivalent logic)

## Programming Concepts

- Constants (`final`)
- Linear search
- Counters
- Accumulators
- Average calculation
- Maximum and minimum value search

---

# 🚫 Restrictions

To keep the challenge aligned with the knowledge covered up to **Chapter 7**, **do not use**:

- Inheritance
- Interfaces
- Exceptions
- Generics beyond `ArrayList`
- Streams
- Lambdas
- Records
- Enums
- Collections other than `ArrayList`
- `Arrays.sort()`
- `Collections.sort()`
- External libraries

---

# ⭐ Bonus Challenges

Implement one or more of the following features without using concepts beyond Chapter 7.

## 1. Remove a Book

Remove a book from the array by shifting every subsequent element one position to the left.

Update `bookCount` accordingly.

---

## 2. Top 5 Most Borrowed Books

Display the five books with the highest number of loans.

Do **not** use any sorting library.

Implement your own algorithm.

---

## 3. Final Report

Before terminating the application, generate a report containing:

- Total registered books
- Total loans
- Total available books
- Average rating
- Most borrowed book
- Highest-rated book
- Complete operation history

---

# 📌 Learning Goals

By completing this project, you should demonstrate proficiency in:

- Object-Oriented Programming
- Java syntax and conventions
- Clean code practices
- Algorithm implementation
- Data organization
- Console application architecture
- Arrays and `ArrayList`
- Matrix manipulation
- Search algorithms
- Control flow structures
