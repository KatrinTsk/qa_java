package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void getSoundCheck() {
        assertEquals("Мяу", new Cat(feline).getSound());
    }

    @Test
    public void getFoodShouldCallEatMeat() throws Exception {
        // should be
        when(feline.eatMeat()).thenReturn(List.of("Мышь"));

        // call
        Cat cat = new Cat(feline);
        List<String> result = cat.getFood();

        // assert
        assertEquals(List.of("Мышь"), result);
        verify(feline).eatMeat();
    }
}