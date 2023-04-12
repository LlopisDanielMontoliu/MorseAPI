package com.MorseAPI.MorseAPI.Service;

import java.util.List;

public interface IMorseTranslatorService {
     String translateToMorse(String input);
     List<String> getCleanedStrings(String input);
}
