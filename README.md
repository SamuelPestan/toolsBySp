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

1. Go to the **lib** folder in this repository.
2. Download the `.jar` file (e.g., `ToolsBySp.jar`).
3. Place the `.jar` file in a folder within your Java project or anywhere accessible to your project.

## Usage

To use the utility library, add the `.jar` file to your project’s build path. Here's how you can include it in a Java project:

### Using Eclipse:

1. Right-click your project in the Project Explorer and select **Build Path** -> **Configure Build Path**.
2. In the **Libraries** tab, click **Add External JARs**.
3. Select the `ToolsBySp.jar` file you downloaded.

### Using NetBeans:

1. Right-click your project in the **Projects** tab and select **Properties**.
2. Go to the **Libraries** category.
3. Click **Add JAR/Folder** and select the `ToolsBySp.jar` file you downloaded.

### Using IntelliJ IDEA:

1. Right-click your project in the **Project** view and select **Add Framework Support**.
2. Choose **Java** and click **OK**.
3. Right-click your project and select **Open Module Settings** (or press `F4`).
4. In the **Modules** tab, go to **Dependencies** and click the `+` icon to add a JAR file.
5. Select the `ToolsBySp.jar` file you downloaded.

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
