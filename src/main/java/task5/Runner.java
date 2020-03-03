package task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static List<Integer> getPalindromes(int range) {
        List<Integer> palimdromes = new ArrayList<>();

        for (int i = 0; i <= range; i++) {
            String number = Integer.toString(i);
            String reversedNumber = new StringBuilder(number).reverse().toString();

            if (number.equals(reversedNumber)) {
                palimdromes.add(Integer.parseInt(number));
            }
        }

        return palimdromes;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter a number from range [1;100]:");

        Pattern p = Pattern.compile("1?\\d?\\d");
        int range;

        while (true) {
            String number = s.nextLine();
            Matcher m = p.matcher(number);

            if (m.matches()) {
                range = Integer.parseInt(number);

                if (range > 0 && range < 101) {
                    break;
                } else {
                    System.out.println("Your number is out of range. Tra again:");
                }

            } else {
                System.out.println("It is not a number. Try again:");
            }
        }

        System.out.println("It is not a correct number. Try again:");
        System.out.println("Your number is out of allowed range. Try again:");


        List<Integer> palindromes = getPalindromes(range);

        System.out.printf("Palindromes in range from 0 to %d inclusive are:\n", range);

        palindromes.forEach(System.out::println);
    }
}
