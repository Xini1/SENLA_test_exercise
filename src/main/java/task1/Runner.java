package task1;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String str;

        while (true) {
            System.out.print("Enter a number: ");

            str = s.nextLine();

            Pattern p = Pattern.compile("\\d+");
            Matcher m1 = p.matcher(str);

            if (!m1.matches()) {
                System.out.println("Incorrect number! You should enter only integers");
                continue;
            }

            break;
        }

        int num = Integer.parseInt(str);

        boolean isEven = num % 2 == 0;

        boolean isPrime = new BigInteger(str).isProbablePrime(1);

        System.out.printf("Your number %d is %s.\n", num, isEven ? "even" : "odd");
        System.out.printf("Your number %d is %s.", num, isPrime ? "prime" : "not prime");

        s.close();
    }
}
