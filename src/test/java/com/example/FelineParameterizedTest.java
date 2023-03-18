package com.example;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineParameterizedTest extends TestCase {

    private final int countKittens;

    public FelineParameterizedTest(int countKittens) {
        this.countKittens = countKittens;
    }


    @Parameterized.Parameters(name = "Получение котят. Тестовые данные: {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {1},
                {2},
        };
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        assertEquals(countKittens, feline.getKittens(countKittens));
    }
}