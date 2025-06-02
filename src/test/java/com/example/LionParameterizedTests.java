package com.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class LionParameterizedTests {

    @Mock
    private Feline feline;

    static Stream<Arguments> testLionSexProvider() {
        return Stream.of(
                Arguments.of("Самец", true, "У льва должна быть грива"),
                Arguments.of("Самка", false, "У львицы не должно быть гривы")
        );
    }

    @ParameterizedTest(name = "Проверка гривы для пола: {0}, ожидается: {1}")
    @MethodSource("testLionSexProvider")
    void doesHaveMane_ShouldReturnCorrectResult(String sex, boolean expectedHasMane, String message) throws Exception {
        // Arrange
        Lion lion = new Lion(sex, feline);

        // Act
        boolean actualHasMane = lion.doesHaveMane();

        // Assert
        assertEquals(expectedHasMane, actualHasMane, message);
    }

//    @ParameterizedTest
//    @MethodSource("testLionSexProvider")
//    void getKittens_ShouldCallFelineMethod(String sex) throws Exception {
//        // Arrange
//        when(feline.getKittens()).thenReturn(11);
//        Lion lion = new Lion(sex, feline);
//
//        // Act
//        int result = lion.getKittens();
//
//        // Assert
//        assertEquals(11, result);
//        verify(feline, times(1)).getKittens();
//    }

}