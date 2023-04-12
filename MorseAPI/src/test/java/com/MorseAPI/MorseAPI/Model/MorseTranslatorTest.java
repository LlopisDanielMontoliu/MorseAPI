package com.MorseAPI.MorseAPI.Model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class MorseTranslatorTest {
    MorseTranslator morseTranslator =new MorseTranslator();
    @Test
    void translate1Letter(){
        assertEquals(".", morseTranslator.translate("E"));
    }

    @Test
    void translate2Letter(){
        assertEquals("...", morseTranslator.translate("IE"));
    }
    @Test
    void translate3Letter(){
        assertEquals("....", morseTranslator.translate("IE E"));
    }



    
    @Test
    void getString(){
        assertTrue( morseTranslator.getPosibleStrings("--.--.---.......-.---.-.-.-..-.....--..-....-.-----..- ","").contains("MAY THE FOR CASE WITH YOU"));
    }
}
