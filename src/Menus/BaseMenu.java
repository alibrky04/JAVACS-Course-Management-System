package Menus;

import java.util.Scanner;

/**
 * Abstract base class for menu systems. Handles the input loop and delegates
 * specific behaviors (header display, menu display, and menu actions)
 * to subclasses via abstract methods.
 */
public abstract class BaseMenu {

    /**
     * Displays the header of the menu.
     * Subclasses must provide the implementation.
     */
    protected abstract void showHeader();

    /**
     * Displays the menu options.
     * Subclasses must provide the implementation.
     */
    protected abstract void showMenu();

    /**
     * Executes actions based on the user's choice.
     * Subclasses must provide the implementation.
     *
     * @param choice the numeric menu option selected by the user
     */
    protected abstract void doMenuActions(int choice);

    /**
     * Gets user input for the menu and validates it as an integer.
     * Retries until a valid input is provided, then calls {@code doMenuActions()}.
     */
    protected void getInput() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (true) {
            System.out.print("Please enter your choice: ");
            String input = scanner.nextLine();
            System.out.println();

            try {
                choice = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.\n");
            }
        }

        doMenuActions(choice);
    }

    /**
     * Runs the menu by showing the header, displaying the menu,
     * and prompting the user for input.
     */
    public void run() {
        showHeader();
        showMenu();
        getInput();
    }
}
