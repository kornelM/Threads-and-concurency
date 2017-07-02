package com.sda.wordsAndLetters;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;

public class Counter {
    private List<String> words;
    private Map<Character, Integer> myMapOfLetters = new HashMap<>();
    private Integer allLetters = 0;

//    public Counter() {
//        try {
//            words = Files.readAllLines(Paths.get("slowa.txt"));
//            for (String word : words) {
//                for (int i = 0; i < word.length(); i++)
//                    allLetters +=1;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public Counter(List<String> allPolishWords) {
        this.words = allPolishWords;
        numberOfAllLetters();

    }

    public Integer getAllLetters() {
        return allLetters;
    }

    private void numberOfAllLetters() {
        for (String s : words)
            for (int i = 0; i < s.length(); i++) {
                allLetters++;
            }
    }

    public int getLettersNumber(Character character) {
        return myMapOfLetters.get(character);
    }


    public Integer numberOfLetter(Character character) {
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == character) {
                    Integer count = myMapOfLetters.getOrDefault(character, 0);
                    myMapOfLetters.put(character, ++count);
                }
            }
        }
        return myMapOfLetters.get(character);
    }

    public void createReport() throws IOException {
        String alphabet = "aąbcćdeęfghijklłmnńoópqrsśtuvwxyzźż";
        PrintWriter wr = new PrintWriter("report.txt");
        double percent;

        DecimalFormat myFormatter = new DecimalFormat("###,###.###");


        wr.println("Number of words: " +   myFormatter.format(words.size()));
        wr.println("Number of letters: " + myFormatter.format(allLetters));

        for (int i = 0; i < alphabet.length(); i++) {
            percent = (double) myMapOfLetters.get(alphabet.charAt(i)) / (double) allLetters * 100;
            wr.printf("%s%s %.4f %s%s%s", String.valueOf(alphabet.charAt(i)), ": ", percent, "%   (", myFormatter.format(myMapOfLetters.get(alphabet.charAt(i))), ")\n");

        }
        wr.close();
    }
    // public static void main(String[] args) throws IOException {
//        List<String> words = Files.readAllLines(Paths.get("slowa.txt"));
//        Map<Character, Integer> map = new HashMap<>();
//        int allLetter = 0;
//        for (String word : words) {
//            for (Character character : word.toCharArray()) {
//                Integer count = map.getOrDefault(character, 0);
//                map.put(character, ++count);
//                ++allLetter;
//            }
//        }
//        Counter counter = new Counter();
//        int aLetterCount = counter.numberOfLetter('a');
//
//        double percent = (double) (aLetterCount) / (double) counter.getAllLetters() * 100;
//        System.out.printf("a: %.3f",percent);
//    }

    //public

}
