package Users;

/**
 * Represents an admin user who can manage courses and system settings.
 */
public class Admin extends User {

    /**
     * Displays the user's role as an admin.
     */
    @Override
    public void showRole() {
        System.out.println("Logged in as Admin.\n");
    }
}
