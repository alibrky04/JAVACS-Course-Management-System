package Menus;

import Entities.Course;
import Managers.CourseManager;
import Users.Admin;

import java.util.Scanner;

/**
 * Represents the administrative menu in the course management system.
 * Provides options for managing courses such as adding and removing them.
 */
public class AdminMenu extends BaseMenu {
    // The admin instance representing the current admin.
    Admin admin = new Admin();

    // Singleton instance of CourseManager to manipulate course list
    CourseManager courseManager = CourseManager.getInstance();

    AdminMenu(){
        admin.showRole();
    }

    /**
     * Displays a welcome message for the admin menu.
     */
    @Override
    protected void showHeader() {
        System.out.println("Welcome to the Admin Menu");
    }

    /**
     * Displays the options available to the administrator.
     */
    @Override
    protected void showMenu() {
        System.out.println("1. Add Course");
        System.out.println("2. Remove Course");
        System.out.println("3. Main Menu");
    }

    /**
     * Executes actions based on the selected menu option.
     *
     * @param choice the administrator's selected action
     */
    @Override
    protected void doMenuActions(int choice) {
        Scanner scanner = new Scanner(System.in);

        try {
            switch (choice) {
                case 1:
                    // Add a new course
                    System.out.print("Enter Course Code: ");
                    String courseCode = scanner.nextLine();

                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();

                    System.out.print("Enter Credit: ");
                    if (!scanner.hasNextFloat()) {
                        System.out.println("\nInvalid input. Credit must be a decimal number.\n");
                        scanner.nextLine();
                        break;
                    }
                    float credit = scanner.nextFloat();
                    scanner.nextLine();

                    System.out.print("Is Course Active? (true/false): ");
                    if (!scanner.hasNextBoolean()) {
                        System.out.println("\nInvalid input. Please enter 'true' or 'false'.\n");
                        scanner.nextLine();
                        break;
                    }
                    boolean active = scanner.nextBoolean();
                    scanner.nextLine();

                    courseManager.addCourse(new Course(courseCode, courseName, credit, active));
                    break;

                case 2:
                    // Remove a course by code
                    System.out.print("Enter Course Code: ");
                    String courseRemovalCode = scanner.nextLine();
                    courseManager.removeCourse(courseRemovalCode);
                    break;

                case 3:
                    // Navigate back to the main menu
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

        // Loop back to menu after action
        showMenu();
        getInput();
    }
}