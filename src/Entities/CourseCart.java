package Entities;

import java.util.ArrayList;
import java.util.List;

/**
 * A generic cart class to manage a collection of {@link Course} objects.
 * Enforces rules such as a maximum credit limit and disallows modifications
 * after the cart is saved.
 *
 * @param <T> a type that extends {@link Course}
 */
public class CourseCart<T extends Course> {

    private final List<T> courses;
    private boolean isSaved;

    private static final float MAX_CREDIT = 30.0f;

    /**
     * Initializes an empty course cart.
     */
    public CourseCart() {
        courses = new ArrayList<>();
        isSaved = false;
    }

    /**
     * Adds a course to the cart if it's valid and within constraints.
     *
     * @param course the course to add
     */
    public void addCourse(T course) {
        System.out.println();

        if (course == null) {
            System.out.println("Course not found.\n");
            return;
        }

        if (isSaved) {
            System.out.println("Cannot add courses. Cart has already been saved.\n");
            return;
        }

        if (!course.active()) {
            System.out.println("This course is not open.\n");
            return;
        }

        if (courses.contains(course)) {
            System.out.println("This course is already in the cart.\n");
            return;
        }

        if (getTotalCredit() + course.credit() > MAX_CREDIT) {
            System.out.println("Credit limit exceeded. Couldn't add the course.\n");
            return;
        }

        courses.add(course);
        System.out.println("Course added.\n");
    }

    /**
     * Removes a course from the cart by course code.
     *
     * @param courseCode the code of the course to remove
     */
    public void removeCourse(String courseCode) {
        if (isSaved) {
            System.out.println("Cannot remove courses. Cart has already been saved.\n");
            return;
        }

        boolean removed = courses.removeIf(c -> c.courseCode().equalsIgnoreCase(courseCode));
        if (!removed) {
            System.out.println("Course not found in cart.\n");
        }
    }

    /**
     * Retrieves a list of all courses in the cart.
     *
     * @return a new list containing the courses
     */
    public List<T> getCourses() {
        return new ArrayList<>(courses);
    }

    /**
     * Finds a course in the cart by its code.
     *
     * @param courseCode the course code to look for
     * @return the matching course or {@code null} if not found
     */
    public T getCourseByCode(String courseCode) {
        for (T course : courses) {
            if (course.courseCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        return null;
    }

    /**
     * Calculates the total number of credits for all courses in the cart.
     *
     * @return the sum of credits
     */
    public float getTotalCredit() {
        float total = 0;
        for (T course : courses) {
            total += course.credit();
        }
        return total;
    }

    /**
     * Marks the cart as saved, preventing further modification.
     */
    public void saveCart() {
        isSaved = true;
        System.out.println("Cart saved. No further changes allowed.\n");
    }

    /**
     * Checks whether the cart has been saved.
     *
     * @return {@code true} if the cart is saved; otherwise {@code false}
     */
    public boolean isSaved() {
        return isSaved;
    }

    /**
     * Displays all courses in the cart and their total credit.
     */
    public void displayCart() {
        if (courses.isEmpty()) {
            System.out.println("Your cart is empty.\n");
            return;
        }

        System.out.println("Courses in your cart:\n");
        for (T course : courses) {
            System.out.println(course + "\n");
        }
        System.out.println("Total credit: " + getTotalCredit() + "\n");
    }
}
