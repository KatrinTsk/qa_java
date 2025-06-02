package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void testGetSoundCheck() {
        assertEquals("Мяу", new Cat(feline).getSound(), "ожидается что getSound() возвращает Мяу");
    }

    @Test
    public void testGetFoodShouldCallEatMeat() throws Exception {
        // should be
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        // call
        Cat cat = new Cat(feline);
        List<String> result = cat.getFood();

        // assert
        assertEquals(List.of("Животные", "Птицы", "Рыба"), result);
        //verify(feline).eatMeat();
    }

}