package task2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {

    public static int maximumCommonDivider(int a, int b) {
        int num1 = Math.abs(a);
        int num2 = Math.abs(b);

        if (num2 == 0) {
            return num1;
        }

        return maximumCommonDivider(num2, num1 % num2);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String str1;
        String str2;

        while (true) {
            System.out.print("Enter first number: ");

            str1 = s.nextLine();

            System.out.print("Enter second number: ");

            str2 = s.nextLine();

            Pattern p = Pattern.compile("-?\\d+");
            Matcher m1 = p.matcher(str1);
            Matcher m2 = p.matcher(str2);

            if (!m1.matches() || !m2.matches()) {
                System.out.println("Incorrect number(s)! You should enter only integers");
                continue;
            }

            break;
        }

        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);

        int mcd = maximumCommonDivider(num1, num2);
        int lcm = num1 * num2 / mcd;

        System.out.printf("For your numbers %d and %d Maximum Common Divider is %d, " +
                "and Least Common Multiple is %d.", num1, num2, mcd, lcm);

        s.close();
    }
}
