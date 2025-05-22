package Users;

import Entities.Course;
import Entities.CourseCart;

/**
 * Represents a student user who can manage a course cart.
 */
public class Student extends User {
    /**
     * The course cart associated with the student.
     */
    private final CourseCart<Course> cart = new CourseCart<>();

    /**
     * Retrieves the course cart for the student.
     *
     * @return the student's course cart
     */
    public CourseCart<Course> getCart() {
        return cart;
    }

    /**
     * Displays the user's role as a student.
     */
    @Override
    public void showRole() {
        System.out.println("Logged in as Student.\n");
    }
}
