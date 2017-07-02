package com.sda.wordsAndLetters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kornel on 30.06.17.
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> words = Files.readAllLines(Paths.get("slowa.txt"));
        //a, ą, b, c, ć, d, e, ę, f, g, h, i, j, k, l, ł, m, n, ń, o, ó, p, (q), r, s, ś, t, u, (v), w, (x), y, z, ź, ż

        String alphabet = "aąbcćdeęfghijklłmnńoópqrsśtuvwxyzźż";
        List<Thread> runThreads = new ArrayList<>();
        List<WordsTask> listOfWordsTasks = new ArrayList<>();
        Counter counter = new Counter(words);

        for (int i = 0; i < alphabet.length(); i++) {
            WordsTask wordsTask = new WordsTask(counter, alphabet.charAt(i));
            Thread thread = new Thread(wordsTask, "thread: " + i);
            thread.start();
            runThreads.add(thread);
            listOfWordsTasks.add(wordsTask);
        }

        for (Thread thread : runThreads) {
            thread.join();
        }


        Integer allLetters = counter.getAllLetters();
        Integer aLetter = counter.getLettersNumber('a');
        double percent = (double) aLetter / (double) allLetters * 100;
        System.out.println("a: " + percent);

        counter.createReport();


    }
}

