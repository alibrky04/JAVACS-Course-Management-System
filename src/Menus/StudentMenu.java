package Menus;

import Entities.Course;
import Managers.CourseManager;
import Users.Student;

import java.util.Scanner;

/**
 * Represents the menu interface for a student.
 * Allows students to view courses, manage their course cart, and navigate the system.
 */
public class StudentMenu extends BaseMenu {

    // The student instance representing the current user.
    Student student = new Student();

    // Singleton CourseManager instance to access available courses.
    CourseManager courseManager = CourseManager.getInstance();

    StudentMenu(){
        student.showRole();
    }

    /**
     * Displays a welcome message for the student menu.
     */
    @Override
    protected void showHeader() {
        System.out.println("Welcome to the Student Menu");
    }

    /**
     * Displays the options available to the student.
     */
    @Override
    protected void showMenu() {
        System.out.println("1. Show All Courses");
        System.out.println("2. Add Course to Cart");
        System.out.println("3. Remove Course from Cart");
        System.out.println("4. Show Cart");
        System.out.println("5. Save Cart");
        System.out.println("6. Main Menu");
    }

    /**
     * Performs the selected menu action based on the student's input.
     *
     * @param choice the student's menu selection
     */
    @Override
    protected void doMenuActions(int choice) {
        Scanner scanner = new Scanner(System.in);
        String courseCode;

        try {
            switch (choice) {
                case 1:
                    // Display all available courses
                    for (Course course : courseManager.getCourses()) {
                        System.out.println(course.toString() + "\n");
                    }
                    break;

                case 2:
                    // Add a course to the student's cart
                    System.out.print("Enter Course Code: ");
                    courseCode = scanner.nextLine();
                    student.getCart().addCourse(courseManager.getCourseByCode(courseCode));
                    System.out.println("Total credit: " + student.getCart().getTotalCredit() + "\n");
                    break;

                case 3:
                    // Remove a course from the student's cart
                    System.out.print("Enter Course Code: ");
                    courseCode = scanner.nextLine();
                    student.getCart().removeCourse(courseCode);
                    System.out.println("Total credit: " + student.getCart().getTotalCredit() + "\n");
                    break;

                case 4:
                    // Display the student's current course cart
                    student.getCart().displayCart();
                    break;

                case 5:
                    // Save the student's course cart (makes it immutable)
                    student.getCart().saveCart();
                    break;

                case 6:
                    // Return to the main menu, resetting the student cart
                    new MainMenu().run();
                    break;

                default:
                    throw new Exception("Invalid Choice\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            showMenu();
            getInput();
        }

        // Redisplay the menu after action is performed
        showMenu();
        getInput();
    }
}
