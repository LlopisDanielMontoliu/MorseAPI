package com.MorseAPI.MorseAPI.Controller;

import com.MorseAPI.MorseAPI.Service.IMorseTranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class MorseTranslatorController {
    @Autowired
    IMorseTranslatorService morseTranslatorService;

    @CrossOrigin
    @GetMapping("/ToMorseTranslator/{input}")
    public List<String> translateToMorse(@PathVariable("input") String input){
        return Collections.singletonList(morseTranslatorService.translateToMorse(input));
    }

    @CrossOrigin
    @GetMapping("/ToStringTranslator/{input}")
    public List<String> translateToHuman(@PathVariable("input") String input){
        return morseTranslatorService.getCleanedStrings(input);
    }
}
