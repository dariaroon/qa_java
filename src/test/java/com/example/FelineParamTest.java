package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParamTest {

    private final int countKittens;

    public FelineParamTest(int countKittens) {
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