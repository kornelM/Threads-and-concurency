package com.sda.primeNumbers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kornel on 29.06.17.
 */
public class FinderTest {
    private Finder finder;


    @Before
    public void setUp() {
        finder = new Finder();
    }

    @Test
    public void shouldFindPrimesFrom1to10() {
        List<Integer> listOfPrimes = finder.find(1, 10);
        final List<Integer> expectedList = Arrays.asList(2, 3, 5, 7);

        Assert.assertEquals(expectedList, listOfPrimes);
    }

    @Test
    public void shouldReturnPrimesFromGivenScope() {
        List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);

        List<Integer> listOfPrimes1 = finder.find(0, 10);
        List<Integer> listOfPrimes2 = finder.find(11, 20);
        List<Integer> listOfPrimes3 = finder.find(21, 30);
        List<Integer> listOfPrimes4 = finder.find(31, 40);
        List<Integer> listOfPrimes5 = finder.find(41, 50);
        List<Integer> listOfPrimes6 = finder.find(51, 60);
        List<Integer> listOfPrimes7 = finder.find(61, 70);
        List<Integer> listOfPrimes8 = finder.find(71, 80);
        List<Integer> listOfPrimes9 = finder.find(81, 90);
        List<Integer> listOfPrimes10 = finder.find(91, 100);

        List<Integer> listOfAllPrimes = new ArrayList<>();

        listOfAllPrimes.addAll(listOfPrimes1);
        listOfAllPrimes.addAll(listOfPrimes2);
        listOfAllPrimes.addAll(listOfPrimes3);
        listOfAllPrimes.addAll(listOfPrimes4);
        listOfAllPrimes.addAll(listOfPrimes5);
        listOfAllPrimes.addAll(listOfPrimes6);
        listOfAllPrimes.addAll(listOfPrimes7);
        listOfAllPrimes.addAll(listOfPrimes8);
        listOfAllPrimes.addAll(listOfPrimes9);
        listOfAllPrimes.addAll(listOfPrimes10);

    Assert.assertEquals(expected, listOfAllPrimes);
    }

    @Test
    public void shouldReturnListWith1_20_21_40_41_60_61_80_81_100WhenScopeIsFrom1To100With5Threads(){
        List<Integer> expectedBottomsAndTops = Arrays.asList(1,20,21,40,41,60, 61,80,81,100);
        List<Integer> listOfBottomsAndTops = finder.divideOnScopes(1,100,5);

        Assert.assertEquals(expectedBottomsAndTops,listOfBottomsAndTops);
    }

}