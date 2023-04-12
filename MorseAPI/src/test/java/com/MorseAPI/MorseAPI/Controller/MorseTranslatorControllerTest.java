package com.MorseAPI.MorseAPI.Controller;

import com.MorseAPI.MorseAPI.Service.MorseTranslatorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
public class MorseTranslatorControllerTest {

    @InjectMocks
    MorseTranslatorController morseTranslatorController;

    @Test
    void endPointTranslatorToMorseETest(){
        morseTranslatorController.morseTranslatorService= Mockito.mock( MorseTranslatorServiceImpl.class);
        Mockito.when( morseTranslatorController.translateToMorse("HOLA MUNDO").get(0)).thenReturn("-----");
        assertEquals("-----", morseTranslatorController.translateToMorse("HOLA MUNDO").get(0));
    }

    @Test
    void endPointTranslateToHumanTest(){
        morseTranslatorController.morseTranslatorService= Mockito.mock( MorseTranslatorServiceImpl.class);
        Mockito.when( morseTranslatorController.translateToHuman(".-.-.-.-.")).thenReturn(List.of("HOLA"));
        assertEquals("HOLA", morseTranslatorController.translateToHuman(".-.-.-.-.").get(0));
    }
}
