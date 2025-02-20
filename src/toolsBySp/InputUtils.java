package toolsBySp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A utility class for getting various types of user input with error handling.
 * 
 * @author Samuel Pestana
 * 
 */
public class InputUtils {

    /**
     * Prompts the user for an integer input and returns the result.
     * If the input is invalid, returns -1.
     *
     * @return the integer entered by the user or -1 if invalid.
     */
    public int askForInt() {
        try (Scanner sc = new Scanner(System.in)) {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    /**
     * Prompts the user for an integer input and returns the result.
     * If the input is invalid, returns null.
     *
     * @return the integer entered by the user or null if invalid.
     */
    public Integer askForInteger() {
        try (Scanner sc = new Scanner(System.in)) {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            return null;
        }
    }

    /**
     * Prompts the user for a float input and returns the result.
     * If the input is invalid, returns -1.
     *
     * @return the float entered by the user or -1 if invalid.
     */
    public float askForFloat() {
        try (Scanner sc = new Scanner(System.in)) {
            return sc.nextFloat();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    /**
     * Prompts the user for a double input and returns the result.
     * If the input is invalid, returns null.
     *
     * @return the double entered by the user or null if invalid.
     */
    public Double askForDouble() {
        try (Scanner sc = new Scanner(System.in)) {
            return sc.nextDouble();
        } catch (InputMismatchException e) {
            return null;
        }
    }

    /**
     * Prompts the user for a string input and returns the result.
     * If the input is invalid, returns null.
     *
     * @return the string entered by the user or null if invalid.
     */
    public String askForString() {
        try (Scanner sc = new Scanner(System.in)) {
            return sc.nextLine();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Prompts the user for a boolean input and returns the result.
     * The input can be "true", "yes", or "1" for true, and "false", "no", or "0" for false.
     * If the input is invalid, returns null.
     *
     * @return the boolean value entered by the user or null if invalid.
     */
    public Boolean askForBoolean() {
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.next().toLowerCase();
            if (input.equals("true") || input.equals("yes") || input.equals("1")) {
                return true;
            } else if (input.equals("false") || input.equals("no") || input.equals("0")) {
                return false;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Prompts the user for a boolean input (in Spanish) and returns the result.
     * The input can be "true", "si", or "1" for true, and "false", "no", or "0" for false.
     * If the input is invalid, returns null.
     *
     * @return the boolean value entered by the user or null if invalid.
     */
    public Boolean askForBooleanEs() {
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.next().toLowerCase();
            if (input.equals("true") || input.equals("si") || input.equals("1")) {
                return true;
            } else if (input.equals("false") || input.equals("no") || input.equals("0")) {
                return false;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Prompts the user for a date input in the format YYYY-MM-DD.
     * If the input is invalid, returns null.
     *
     * @return the date entered by the user in the format YYYY-MM-DD or null if invalid.
     */
    public String askForDate() {
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine();
            LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
            return input;
        } catch (DateTimeParseException e) {
            return null;
        }
    }
    
    /**
     * Formats the given LocalDate into a string according to the provided pattern.
     * The method uses the DateTimeFormatter to format the date into a human-readable string based on the specified pattern.
     * 
     * @param date The LocalDate object to be formatted.
     * @param pattern The pattern to be used for formatting the date (e.g., "yyyy-MM-dd", "dd/MM/yyyy").
     * @return A string representing the formatted date.
     */
    public String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    
    /**
     * Prompts the user to enter an email address and validates the format.
     * If the email format is valid, it returns the email. Otherwise, it returns null.
     *
     * @return a valid email address if the input is correct, or null if the format is invalid.
     */
    public String askForEmail() {
        try(Scanner sc = new Scanner(System.in)) {
        	String email = sc.nextLine();
            
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);
            
            if (matcher.matches()) {
                return email;
            } else {
                return null;
            }
        }
    }
    
    /**
     * Prompts the user to input a phone number and validates it with a flexible format (international with separators).
     * The method validates the phone number using a regular expression, allowing an optional country code
     * and ensuring the number contains between 10 and 15 digits.
     * 
     * @return the valid phone number entered by the user, or null if the input is invalid
     */
    public String askForPhoneNumberFlexible() {
        try (Scanner sc = new Scanner(System.in)) {
            // Prompt the user for the phone number input
            String phoneNumber = sc.nextLine();

            // Regular expression for phone number (optional country code + 10 to 15 digits)
            String phoneRegex = "^\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}$";
            Pattern pattern = Pattern.compile(phoneRegex);
            Matcher matcher = pattern.matcher(phoneNumber);

            // If the phone number matches the regex, it's valid
            if (matcher.matches()) {
                return phoneNumber; // Return valid phone number
            } else {
                return null; // Invalid phone number format
            }
        }
    }

    /**
     * Prompts the user to input a phone number and validates it using only digits (strict validation).
     * This method ensures that the number consists of digits only, without any separators or country codes.
     * 
     * @return the valid phone number entered by the user, or null if the input is invalid
     */
    public String askForPhoneNumberStrict() {
        try (Scanner sc = new Scanner(System.in)) {
            // Prompt the user for the phone number input
            String phoneNumber = sc.nextLine();

            // Regular expression for strictly digits (10 to 15 digits)
            String phoneRegex = "^\\d{10,15}$";
            Pattern pattern = Pattern.compile(phoneRegex);
            Matcher matcher = pattern.matcher(phoneNumber);

            // If the phone number matches the regex, it's valid
            if (matcher.matches()) {
                return phoneNumber; // Return valid phone number
            } else {
                return null; // Invalid phone number format
            }
        }
    }

    
    /**
     * Prompts the user to input an ISBN and validates it.
     * The method supports both ISBN-10 and ISBN-13 formats and checks if the ISBN is valid based on the format and checksum.
     * 
     * @return the valid ISBN entered by the user, or null if the input is invalid
     */
    public String askForISBN() {
        try (Scanner sc = new Scanner(System.in)) {
            String isbn = sc.nextLine();

            // Regular expression for ISBN-10 or ISBN-13
            String isbnRegex = "^(?:\\d{9}[0-9X]|\\d{13})$";
            Pattern pattern = Pattern.compile(isbnRegex);
            Matcher matcher = pattern.matcher(isbn);

            if (matcher.matches()) {
                // Validate checksum for ISBN-10
                if (isbn.length() == 10) {
                    if (isValidISBN10(isbn)) {
                        return isbn; // Valid ISBN-10
                    } else {
                        return null; // Invalid ISBN-10 checksum
                    }
                }

                // Validate checksum for ISBN-13
                if (isbn.length() == 13) {
                    if (isValidISBN13(isbn)) {
                        return isbn; // Valid ISBN-13
                    } else {
                        return null; // Invalid ISBN-13 checksum
                    }
                }

            }
            return null; // Invalid ISBN format
        }
    }

    /**
     * Validates the checksum for an ISBN-10 number.
     * The ISBN-10 checksum is calculated using a weighted sum of the digits, where the last digit can be 'X'.
     * 
     * @param isbn the ISBN-10 string to validate
     * @return true if the ISBN-10 is valid, false otherwise
     */
    private boolean isValidISBN10(String isbn) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (isbn.charAt(i) - '0') * (10 - i);
        }
        char lastChar = isbn.charAt(9);
        sum += (lastChar == 'X') ? 10 : (lastChar - '0');

        return sum % 11 == 0;
    }

    /**
     * Validates the checksum for an ISBN-13 number.
     * The ISBN-13 checksum is calculated using a weighted sum of the digits, alternating between weights of 1 and 3.
     * 
     * @param isbn the ISBN-13 string to validate
     * @return true if the ISBN-13 is valid, false otherwise
     */
    private boolean isValidISBN13(String isbn) {
        int sum = 0;
        for (int i = 0; i < 13; i++) {
            int digit = isbn.charAt(i) - '0';
            if (i % 2 == 0) {
                sum += digit;
            } else {
                sum += digit * 3;
            }
        }

        return sum % 10 == 0;
    }

    /**
     * Asks the user for a credit card number, validates its format (15 or 16 digits),
     * and checks its validity using the Luhn algorithm.
     * 
     * @return the valid credit card number if it matches the required format and checksum, 
     *         otherwise returns null.
     */
    public String askForCreditCard() {
        try (Scanner sc = new Scanner(System.in)) {
            String cardNumber = sc.nextLine();
            
            // Regex to validate the card number format (15 or 16 digits)
            String cardRegex = "^(\\d{16}|\\d{15})$";
            
            // Checks if the card number has 15 or 16 digits
            if (cardNumber.matches(cardRegex)) {
                // Validates the card number using the Luhn algorithm
                if (isValidCreditCard(cardNumber)) {
                    return cardNumber; // Valid credit card number based on Luhn's algorithm
                } else {
                    return null; // Invalid credit card number
                }
            } else {
                return null; // The card number doesn't match the expected format
            }
        }
    }

    /**
     * Validates a credit card number using the Luhn algorithm.
     * The Luhn algorithm is a simple checksum formula used to validate a variety of identification numbers, 
     * including credit card numbers.
     * 
     * @param cardNumber the credit card number to validate
     * @return true if the card number is valid based on the Luhn algorithm, false otherwise
     */
    private boolean isValidCreditCard(String cardNumber) {
        int sum = 0;
        boolean shouldDouble = false;

        // Iterates over the card number from the end to the start
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(cardNumber.charAt(i));

            // Doubles every other digit, starting from the second-to-last digit
            if (shouldDouble) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9; // Subtract 9 if the doubled digit is greater than 9
                }
            }

            sum += digit;
            shouldDouble = !shouldDouble; // Toggles the shouldDouble flag
        }

        // A valid card number has a checksum that is divisible by 10
        return sum % 10 == 0;
    }
}
