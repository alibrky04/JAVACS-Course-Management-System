# JAVACS - Course Management System Simulation

## Overview
JAVACS is a simple console-based Java application simulating a course selection system used by students and administrators. It demonstrates core object-oriented programming concepts including inheritance, polymorphism, exception handling, and use of generics.

The system supports two types of users with different roles:

- **Student**: Can view all courses, add/remove courses to/from a personal cart, and save the cart.
- **Admin**: Can add or remove courses from the master course list.

## Features
- Role-based menus (Student/Admin)
- Course listing and management
- Course cart for students with credit limit validation (max 30 credits)
- Input validation and exception handling
- Generic CourseCart class managing course collections
- Singleton pattern for course management
- Console-based UI using an abstract base menu class for extensibility

## Usage
1. Compile the project.
2. Run the `Main` class to start the application.
3. Follow on-screen prompts to select user role and navigate menus.

## Constraints & Validations
- Students cannot add closed or non-existent courses.
- Students can add courses up to a maximum of 30 credits.
- Students cannot modify the cart after saving it.
- Admins cannot add duplicate courses or remove courses not in the list.
- Invalid menu inputs are handled gracefully with appropriate messages.

## Requirements
- Java 8 or higher
- Console environment (command line or IDE terminal)

## How to Compile and Run
You can compile all `.java` files and run the `Main` class from the command line:

```bash
javac -d bin $(find src -name "*.java")
java -cp bin Main
