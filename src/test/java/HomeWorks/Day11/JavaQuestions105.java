package HomeWorks.Day11;

import java.util.*;

public class JavaQuestions105 {

    public static void main(String[] args) {
        // Call the methods for each question
        System.out.println("Reversed String: " + reverseString("emir"));
        swapNumbers(3, 6);
        System.out.println("Fibonacci Number: " + fibonacciNumber(9));
        System.out.println("Is Prime: " + isPrime(2));
        System.out.println("Is Prime: " + isPrime(0));
        System.out.println("Is Prime: " + isPrime(-234));
        System.out.println("Is Prime: " + isPrime(123456));
        System.out.println("Difference Min-Max: " + differenceMinMax(new int[]{1, 7, 0, 2, 3, 6, 7}));

        System.out.println("Is Palindrome: " + isPalindrome("level"));
        System.out.println("Is Armstrong: " + isArmstrong(153));

        List<Integer> listWithDuplicates = Arrays.asList(1, 2, 3, 4, 1, 2, 5);
        System.out.println("List after removing duplicates: " + removeDuplicates(listWithDuplicates));

        int[] arrayForPairs = {4, 6, 5, -10, 8, 5, 20};
        findPairsWithSum(arrayForPairs, 10);

        System.out.println("Word count in the sentence: " + countWords("Ali came to school and Ayse came to school"));

        String strForDuplicates = "Hello World!";
        System.out.println("Duplicate characters in the string: " + findDuplicateCharacters(strForDuplicates));
    }

    // Question 1: Reverse a String
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    // Question 2: Swap two numbers
    public static void swapNumbers(int a, int b) {
        System.out.println("Before swap: a=" + a + ", b=" + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After swap: a=" + a + ", b=" + b);
    }

    // Question 3: Fibonacci Number
    public static long fibonacciNumber(int digit) {
        if (digit <= 0) {
            System.out.println("Please enter a positive digit");
            return -1;
        }
        long a = 1, b = 1;
        for (int i = 3; i <= digit; i++) {
            long next = a + b;
            a = b;
            b = next;
        }
        return b;
    }

    // Question 4: Check if a number is Prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Question 5: Difference between Min and Max in an array
    public static int differenceMinMax(int[] input) {
        Arrays.sort(input);
        return input[input.length - 1] - input[0];
    }

    // Question 6: Check if a String is Palindrome
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    // Question 7: Check if a number is Armstrong
    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int n = String.valueOf(number).length();
        int result = 0;
        while (number != 0) {
            int digit = number % 10;
            result += Math.pow(digit, n);
            number /= 10;
        }
        return result == originalNumber;
    }

    // Question 8: Remove duplicates from a list
    public static List<Integer> removeDuplicates(List<Integer> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    // Question 9: Find pairs in an array with a given sum
    public static void findPairsWithSum(int[] array, int targetSum) {
        Set<Integer> seenNumbers = new HashSet<>();
        for (int num : array) {
            int complement = targetSum - num;
            if (seenNumbers.contains(complement)) {
                System.out.println("Pair: (" + num + ", " + complement + ")");
            }
            seenNumbers.add(num);
        }
    }

    // Question 10: Count words in a sentence
    public static Map<String, Integer> countWords(String sentence) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = sentence.toLowerCase().split("\\s+");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

    // Question 11: Find duplicate characters in a string
    public static Set<Character> findDuplicateCharacters(String str) {
        Set<Character> duplicates = new HashSet<>();
        Set<Character> seenCharacters = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (!seenCharacters.add(c)) {
                duplicates.add(c);
            }
        }
        return duplicates;
    }
}

