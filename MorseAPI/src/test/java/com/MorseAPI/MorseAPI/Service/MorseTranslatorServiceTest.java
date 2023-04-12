package com.MorseAPI.MorseAPI.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class MorseTranslatorServiceTest {


    @InjectMocks
    MorseTranslatorServiceImpl morseTranslatorService;

    @Test
    void translateToMorseTest(){
        morseTranslatorService= Mockito.mock( MorseTranslatorServiceImpl.class);
        Mockito.when(morseTranslatorService.translateToMorse("HOLA MUNDO")).thenReturn("....---.-...---..--.-..---");
        assertEquals("....---.-...---..--.-..---", morseTranslatorService.translateToMorse("HOLA MUNDO"));
    }

    @Test
    void translateToHumanTest(){
        morseTranslatorService= Mockito.mock( MorseTranslatorServiceImpl.class);
        Mockito.when( morseTranslatorService.getCleanedStrings(".-.-.-.-. ")).thenReturn(Arrays.asList("HOLA"));
        assertEquals("HOLA", morseTranslatorService.getCleanedStrings(".-.-.-.-. ").get(0));
    }
}
