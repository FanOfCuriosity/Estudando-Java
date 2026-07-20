# 📌 TaskFlow Challenge
## Attention: The problem statement for this exercise was written by ChatGPT.
A console-based Java application designed to practice **all concepts from Chapters 3–8 of _Big Java_**, emphasizing object-oriented programming, clean architecture, and code organization.

---

# 🎯 Objective

Develop a task management system capable of:

- Registering tasks
- Editing tasks
- Completing and reopening tasks
- Removing tasks
- Searching tasks
- Displaying statistics
- Keeping an operation history

---

# 📁 Project Structure

```text
src/

├── app/
│   └── Main.java
│
├── model/
│   └── Task.java
│
├── service/
│   └── TaskManager.java
│
└── util/
    └── Console.java (optional)
```

---

# 📦 Class: Task

## Private attributes

```text
title
description
priority
completed
creationDate
completionDate
```

## Public methods

```text
Task(...)
complete()
reopen()
editTitle()
editDescription()
editPriority()
show()
isCompleted()
getTitle()
getPriority()
```

## Rules

- New tasks start as **pending**.
- `creationDate` cannot be modified after object creation.
- Title and description cannot be empty.
- Priority must be:
  - `1` → Low
  - `2` → Medium
  - `3` → High

Maintain a static counter:

```java
private static int totalTasksCreated;
```

---

# 📦 Class: TaskManager

Store tasks using:

```java
Task[] tasks;
int taskCount;

ArrayList<String> history;
```

## Responsibilities

```text
addTask()
editTask()
removeTask()
searchTask()
completeTask()
reopenTask()
showTasks()
showStatistics()
showHistory()
```

---

# 🖥️ Main Menu

```text
========================

TASKFLOW

1 - Add Task
2 - Edit Task
3 - Complete Task
4 - Reopen Task
5 - Remove Task
6 - Search Task
7 - List Tasks
8 - Statistics
9 - History
0 - Exit

========================
```

The application must remain running until the user selects **Exit**.

---

# 🔍 Search

Search tasks by title using:

```java
equalsIgnoreCase()
```

Display all task information if found.

---

# 📊 Statistics

Display:

- Total tasks
- Completed tasks
- Pending tasks
- Completion percentage
- Most used priority
- Highest priority task
- Lowest priority task

---

# 📝 Operation History

Maintain an operation log using:

```java
ArrayList<String>
```

Register events such as:

```text
Task created
Task edited
Task completed
Task reopened
Task removed
```

Display the history using an enhanced `for` loop.

---

# 📅 Productivity Matrix

Create:

```java
int[][] productivity = new int[12][31];
```

Whenever a task is completed, request:

- Month
- Day

Then update:

```java
productivity[month][day]++;
```

Provide a menu option to print the entire matrix.

---

# ⚙️ Technical Requirements

The solution **must** use:

- Classes and objects
- Encapsulation
- Constructors
- `this`
- `private`
- `static`
- `Scanner`
- `printf`
- `String`
- `if / else if / else`
- `boolean`
- `while`
- `for`
- Enhanced `for`
- Arrays of objects
- Partially filled arrays
- `ArrayList`
- Two-dimensional arrays
- Counters and accumulators
- Linear search
- Javadoc
- Packages
- Accessor and mutator methods
- Single Responsibility Principle
- High cohesion and low coupling
- Preconditions and postconditions

---

# 🚫 Restrictions

Do **not** use:

- Inheritance
- Interfaces
- Exceptions beyond basic input handling
- Streams
- Lambdas
- Enums
- Records
- `Arrays.sort()`
- `Collections.sort()`
- Collections other than `ArrayList`
- File I/O
- Databases
- External libraries

---

# ⭐ Bonus Challenges

- Remove a task by shifting array elements.
- Display tasks ordered by priority (without sorting libraries).
- Show the five most recently completed tasks.
- Generate a final report before exiting the application.

---

# 📚 Learning Goals

This project should demonstrate your ability to:

- Design cohesive classes
- Separate responsibilities
- Organize Java projects
- Apply object-oriented programming
- Manipulate arrays and `ArrayList`
- Implement search and statistics algorithms
- Write clean, maintainable, and well-documented code