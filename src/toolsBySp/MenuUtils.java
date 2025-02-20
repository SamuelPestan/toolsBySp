package toolsBySp;

import java.util.Scanner;

/**
 * This class is used for creating and displaying menus based on an array of options.
 * 
 * @author Samuel Pestana
 * 
 */
public class MenuUtils {

	/**
	 * Displays a menu based on an array of options provided by the user.
	 * It shows the options to the user and asks them to choose one by entering the corresponding number.
	 * If the user enters an invalid choice (not a number or outside the valid range), they are prompted again.
	 *
	 * @param options An array of strings representing the options in the menu.
	 * @return The number of the chosen option. The number corresponds directly to the user's input.
	 */
    public int displayMenu(String[] options) {
        Scanner sc = new Scanner(System.in);
        
        // Display all options
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ".- " + options[i]);
        }
        
        // Get the user's choice
        int choice = -1;
        while (choice < 1 || choice > options.length) {
            try {
                choice = sc.nextInt();
                if (choice < 1 || choice > options.length) {
                }
            } catch (Exception e) {
                sc.nextLine(); // Clear the buffer
            }
        }
        sc.close();
        return choice;
    }
    
    /**
     * Displays a menu based on an array of options provided by the user and displays a custom error message if the input is invalid.
     * It shows the options to the user and asks them to choose one by entering the corresponding number.
     * If the user enters an invalid choice (not a number or outside the valid range), the custom error message is shown.
     *
     * @param options An array of strings representing the options in the menu.
     * @param errorMessage A custom message that will be shown to the user if the input is invalid.
     * @return The number of the chosen option. The number corresponds directly to the user's input.
     */
    public int displayMenu(String[] options, String errorMessage) {
        Scanner sc = new Scanner(System.in);
        
        // Display all options
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ".- " + options[i]);
        }
        
        // Get the user's choice
        int choice = -1;
        while (choice < 1 || choice > options.length) {
            try {
                choice = sc.nextInt();
                if (choice < 1 || choice > options.length) {
                    System.out.println(errorMessage);
                }
            } catch (Exception e) {
                System.out.println(errorMessage);
                sc.nextLine(); // Clear the buffer
            }
        }
        sc.close();
        return choice;
    }
}

