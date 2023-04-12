package com.MorseAPI.MorseAPI.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MorseTranslator {

    final static String WORDS_FILE="C:\\Users\\dmontoliu\\Downloads\\MorseAPI (1)\\MorseAPI\\src\\words.txt";
    Map<String, String> map = new HashMap<>();
    List<String> words = new ArrayList<>();

    public MorseTranslator() {
        map.put( "A",".-");
        map.put("B", "-...");
        map.put("C", "-.-.");
        map.put("D", "-..");
        map.put("E", ".");
        map.put("F", "..-.");
        map.put( "G", "--.");
        map.put( "H", "....");
        map.put( "I", "..");
        map.put( "J", ".---");
        map.put( "K", "-.-");
        map.put( "L", ".-..");
        map.put( "M", "--");
        map.put( "N", "-.");
        map.put( "O", "---");
        map.put( "P", ".--.");
        map.put( "Q", "--.-");
        map.put( "R", ".-.");
        map.put( "S", "...");
        map.put( "T", "-");
        map.put( "U", "..-");
        map.put( "V", "...-");
        map.put( "W", ".--");
        map.put( "X", "-..-");
        map.put( "Y", "-.--");
        map.put( "Z", "--..");
        String cadena;
        try {
            FileReader f = new FileReader(WORDS_FILE);
            BufferedReader b = new BufferedReader(f);
            while ((cadena = b.readLine()) != null) {
                words.add(cadena.toUpperCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String translate(String textToTraduce){
        String result="";
        for (int i = 0; i < textToTraduce.length(); i++) {
            String key = String.valueOf(textToTraduce.charAt(i)).toUpperCase();
            result+= getValue(key);

        }
        return result;
    }

    public String getValue(String key){
        if(map.containsKey(key)){
            return map.get(key);
        }
        return "";
    }

    public List<String> getPosibleStrings(String textToTraduce, String translatedText){
        List<String> resultList=new ArrayList<>();
        for (String word: words) {
            resultList.addAll(cleanTextToTraduce(textToTraduce,word,translatedText));
        }
        return resultList;
    }

    public List<String> cleanTextToTraduce(String textToTraduce, String word, String translatedText) {
        List<String> resultList=new ArrayList<>();
        String translated= translate(word);

        if(textToTraduce.startsWith(translated)){
            String textCleaned=textToTraduce.replaceFirst(translated,"");
            String nextTranslatedText;
            if(translatedText.equals(""))nextTranslatedText=word;
            else nextTranslatedText=translatedText+" "+word;
            resultList.add(nextTranslatedText);
            resultList.addAll(getPosibleStrings(textCleaned,nextTranslatedText));
        }
        return resultList;

    }

    public List<String> cleanResults( String notTranslatedText, List<String> results) {
        List<String> cleanResultsList=new ArrayList<>();
        for (String text :
                results) {
            if(translate(text).equals(notTranslatedText)) {
                cleanResultsList.add(text);
            }
        }
        return cleanResultsList;
    }
}
