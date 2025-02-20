# ToolsBySp - Utility Library

ToolsBySp is a Java utility library designed to make common tasks easier for developers. It provides a variety of helper methods for input validation, date formatting, menu generation, and more.

## Features

- Input validation methods (e.g., email, ISBN, phone number).
- Date formatting methods.
- Menu creation with user input.
- Credit card validation using the Luhn algorithm.
- And much more...

## Installation

To use this library in your Java project, you can download the compiled `.jar` file from the [lib](https://github.com/SamuelPestan/toolsBySp/blob/master/lib) section of this repository, or follow these steps:

1. Download the `.jar` file from the latest release.
2. Place the `.jar` file in a folder within your Java project or anywhere accessible to your project.

## Usage

To use the utility library, add the `.jar` file to your project’s build path. Here's how you can include it in a Java project:

### Using Eclipse:

1. Right-click your project in the Project Explorer and select **Build Path** -> **Configure Build Path**.
2. In the **Libraries** tab, click **Add External JARs**.
3. Select the `ToolsBySp.jar` file you downloaded.

### Example Usage:

Once you've added the `.jar` file, you can use the methods in your project like this:

```java
import toolsBySp.InputUtils;
import toolsBySp.MenuUtils;

public class Main {
    public static void main(String[] args) {
        InputUtils inputUtils = new InputUtils();

        // Ask for an email
        String email = inputUtils.askForEmail();
        if (email != null) {
            System.out.println("Valid email: " + email);
        } else {
            System.out.println("Invalid email.");
        }

        // Display a menu
        String[] menuOptions = {"Option 1", "Option 2", "Option 3"};
        MenuUtils menuUtils = new MenuUtils();
        int choice = menuUtils.displayMenu(menuOptions);
        System.out.println("You selected: " + menuOptions[choice]);
    }
}
```
