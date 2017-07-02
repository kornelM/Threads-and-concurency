package com.sda.wordsAndLetters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kornel on 01.07.17.
 */
public class WordsTask implements Runnable {
    Counter counter;

    private Integer numberOfLetters;
    private Integer allLetters = 0;
    private Character character;

    private List<String> words;
    private Map<Character, Integer> myMapOfLetters = new HashMap<>();

    public WordsTask(Counter counter, Character character) {
        this.counter = counter;
        this.character = character;
    }

    @Override
    public void run() {
        numberOfLetters = counter.numberOfLetter(character);
        //allLetters = counter.getAllLetters();


        //zrobić pętle tworzącą countery i wywołujące metody w róznych wątkach
    }

    public Integer getNumberOfLetters() {
        return numberOfLetters;
    }

    public Integer getAllLetters() {
        return allLetters;
    }

    public Character getCharacter() {
        return character;
    }

    public List<String> getWords() {
        return words;
    }

    public Map<Character, Integer> getMyMapOfLetters() {
        return myMapOfLetters;
    }
}
