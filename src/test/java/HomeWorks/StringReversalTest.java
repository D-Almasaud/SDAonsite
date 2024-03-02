package HomeWorks;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringReversalTest {

    @Test
    public void testReverseString() {
        // Test the reverseString method
        String originalString = "Danah Almasaud";
        String reversedString = reverseString(originalString);
        String expectedReversedString = "duasamlA hanaD";

        // Print the original and reversed strings
        System.out.println("Original String: " + originalString);
        System.out.println("Reversed String: " + reversedString);

        // Assert that the reversed string matches the expected result
        assertEquals(expectedReversedString, reversedString);
    }

    // Method to reverse a string using charAt
    public String reverseString(String input) {
        // Create a StringBuilder to store the reversed string
        StringBuilder reversedStringBuilder = new StringBuilder();

        // Iterate through the original string in reverse order using charAt
        for (int i = input.length() - 1; i >= 0; i--) {
            reversedStringBuilder.append(input.charAt(i));
        }

        // Convert StringBuilder back to a string
        return reversedStringBuilder.toString();
    }
}

