package task6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {

    public static String askForCorrectNumber() {
        String str = s.nextLine();
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(str);

        while (!m.matches()) {
            System.out.println("It is not a number. Try again:");
            str = s.nextLine();
            m = p.matcher(str);
        }

        return str;
    }

    public static final Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();

        while (true) {
            System.out.println("Write a name of item. Leave empty to stop");

            String name = s.nextLine();

            if (name.equals("")) {
                break;
            }

            System.out.println("Write weight of this item:");

            int weight = Integer.parseInt(askForCorrectNumber());

            System.out.println("Write value of this item:");

            int value = Integer.parseInt(askForCorrectNumber());

            items.add(new Item(name, weight, value));
            System.out.println("Item added to list!\n");
        }

        System.out.println("Enter backpack's carrying capacity:");

        int capacity = Integer.parseInt(askForCorrectNumber());

        Backpack backpack = new Backpack(capacity);

        Comparator<Item> comparator = (item1, item2) -> {
            double valuePerWeight1 = (double) item1.getValue() / item1.getWeight();
            double valuePerWeight2 = (double) item2.getValue() / item2.getWeight();

            if (valuePerWeight1 == valuePerWeight2) {

                if (item1.getValue() == item2.getValue()) {
                    return item1.getWeight() - item2.getWeight();
                } else {
                    return item2.getValue() - item1.getValue();
                }

            } else {
                double difference = valuePerWeight2 - valuePerWeight1;
                return difference < 0 ? (int) Math.floor(difference) : (int) Math.ceil(difference);
            }
        };

        items.stream()
                .filter(item -> item.getWeight() <= backpack.getMaxWeight())
                .sorted(comparator)
                .forEach(backpack::addItem);

        System.out.println("\nContents of backpack with maximum possible total value:");
        backpack.printContents();
        System.out.println("Total value is: " + backpack.getCurrentValue());
    }
}
