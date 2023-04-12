package com.MorseAPI.MorseAPI.Service;

import com.MorseAPI.MorseAPI.Model.MorseTranslator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MorseTranslatorServiceImpl implements IMorseTranslatorService {
    MorseTranslator morseTranslator=new MorseTranslator();
    @Override
    public String translateToMorse(String input) {
        return morseTranslator.translate(input+" ");
    }

    @Override
    public List<String> getCleanedStrings(String input) {
        return morseTranslator.cleanResults(input, morseTranslator.getPosibleStrings(input, ""));
    }
}
