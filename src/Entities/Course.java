package Entities;

/**
 * Represents a course with a code, name, credit value, and status.
 * This class is immutable and uses Java's record feature.
 *
 * @param courseCode The unique identifier for the course.
 * @param courseName The descriptive name of the course.
 * @param credit     The number of credits assigned to the course.
 * @param active     The status of the course; {@code true} if the course is open for registration.
 */
public record Course(String courseCode, String courseName, float credit, boolean active) {

    /**
     * Returns a formatted string representation of the course details.
     *
     * @return A multi-line string displaying course code, name, credit, and status.
     */
    @Override
    public String toString() {
        return "Course Code: " + courseCode +
                "\nCourse Name: " + courseName +
                "\nCredit: " + credit +
                "\nStatus: " + (active ? "Open" : "Closed");
    }
}
