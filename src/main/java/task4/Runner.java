package task4;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Write a text:");

        String text = s.nextLine().toLowerCase();

        Map<String, Integer> words = new HashMap<>();

        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(text);

        while (m.find()) {
            String word = m.group();
            words.put(word, words.getOrDefault(word, 0) + 1);
        }

        System.out.println("Write a word to search for:");

        String searchFor = s.nextLine().toLowerCase();
        m = p.matcher(searchFor);

        while (!m.matches()) {
            System.out.println("It is not a word! Try again:");
            searchFor = s.nextLine().toLowerCase();
            m = p.matcher(searchFor);
        }

        System.out.printf("Number of appearances of word \"%s\" in text: %d", searchFor,
                words.getOrDefault(searchFor, 0));

        s.close();
    }
}
