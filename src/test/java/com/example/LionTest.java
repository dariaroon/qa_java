package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");

    }

    @Test(expected = Exception.class)
    public void testExceptionSex() throws Exception {
        new Lion(feline, "Неизвестно");
    }
}
