package Menus;

/**
 * Represents the main entry point of the JAVACS Course Management System.
 * Provides options to navigate to the Student or Admin menus.
 */
public class MainMenu extends BaseMenu {

    /**
     * Displays the welcome header for the main menu.
     */
    @Override
    protected void showHeader() {
        System.out.println("Welcome to JAVACS - Your Course Management System");
    }

    /**
     * Displays the available options in the main menu.
     */
    @Override
    protected void showMenu() {
        System.out.println("1. Student Menu");
        System.out.println("2. Admin Menu");
    }

    /**
     * Executes actions based on the user's choice:
     * - 1: Navigates to the Student Menu.
     * - 2: Navigates to the Admin Menu.
     *
     * @param choice the user's numeric menu selection
     */
    @Override
    protected void doMenuActions(int choice) {
        try {
            switch (choice) {
                case 1:
                    new StudentMenu().run();
                    break;
                case 2:
                    new AdminMenu().run();
                    break;
                default:
                    throw new Exception("Invalid Choice\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            showMenu();
            getInput();
        }

        showMenu();
        getInput();
    }
}
