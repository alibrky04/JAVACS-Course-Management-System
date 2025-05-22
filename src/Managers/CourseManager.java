package Managers;

import Entities.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class that manages the list of available courses.
 * Provides methods to retrieve, add, and remove courses.
 */
public class CourseManager {

    private static CourseManager instance;
    private final List<Course> courses;

    /**
     * Private constructor that initializes the course list with default values.
     */
    private CourseManager() {
        courses = new ArrayList<>();
        courses.add(new Course("YMH101", "Introduction to Programming", 29f, true));
        courses.add(new Course("YMH102", "Data Structures", 4.0f, true));
        courses.add(new Course("YMH201", "Algorithms", 3.5f, true));
        courses.add(new Course("YMH220", "Operating Systems", 5.0f, false));
        courses.add(new Course("YMH255", "Software Economy", 4.0f, true));
        courses.add(new Course("YMH300", "Database Systems", 3.0f, true));
        courses.add(new Course("YMH310", "Web Development", 4.5f, false));
        courses.add(new Course("YMH340", "Computer Networking", 5.0f, true));
        courses.add(new Course("YMH360", "Mobile App Development", 3.0f, true));
        courses.add(new Course("YMH370", "Machine Learning", 4.0f, false));
    }

    /**
     * Retrieves the singleton instance of {@code CourseManager}.
     *
     * @return the single instance of {@code CourseManager}
     */
    public static CourseManager getInstance() {
        if (instance == null) {
            instance = new CourseManager();
        }
        return instance;
    }

    /**
     * Gets the list of all courses.
     *
     * @return a list of {@link Course} objects
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Finds a course by its course code.
     *
     * @param courseCode the code of the course
     * @return the matching {@link Course}, or {@code null} if not found
     */
    public Course getCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.courseCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        return null;
    }

    /**
     * Adds a course to the list if no other course has the same code or name.
     *
     * @param course the {@link Course} to add
     */
    public void addCourse(Course course) {
        System.out.println();
        for (Course c : courses) {
            if (c.courseCode().equalsIgnoreCase(course.courseCode())) {
                System.out.println("A course with this code already exists. Cannot add duplicate.\n");
                return;
            }
            if (c.courseName().equalsIgnoreCase(course.courseName())) {
                System.out.println("A course with this name already exists. Cannot add duplicate.\n");
                return;
            }
        }
        courses.add(course);
        System.out.println("Course added successfully.\n");
    }

    /**
     * Removes a course from the list using its code.
     *
     * @param courseCode the code of the course to remove
     */
    public void removeCourse(String courseCode) {
        System.out.println();
        for (Course course : courses) {
            if (course.courseCode().equalsIgnoreCase(courseCode)) {
                courses.remove(course);
                System.out.println("Course removed successfully.\n");
                return;
            }
        }
        System.out.println("Course not found. Nothing was removed.\n");
    }
}
