package task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Runner {

    public static List<String> makeFirstLettersUpperCase(List<String> list) {
        return list.stream()
                .map(str -> {
                    String firstLetter = str.substring(0, 1);
                    String remainingPart = str.substring(1);
                    return firstLetter.toUpperCase() + remainingPart;
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Write a sentence:");

        String sentence = s.nextLine();

        List<String> words = new ArrayList<>();

        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(sentence.toLowerCase());

        while (m.find()) {
            words.add(m.group());
        }

        words = makeFirstLettersUpperCase(words);

        Collections.sort(words);

        System.out.println("Number of words in you sentence: " + words.size());

        words.forEach(System.out::println);

        s.close();
    }
}
