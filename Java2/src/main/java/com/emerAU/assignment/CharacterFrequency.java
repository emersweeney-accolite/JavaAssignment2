package com.emerAU.assignment;

import org.apache.commons.cli.*;
import java.util.HashMap;
import java.util.Map;

public class CharacterFrequency {

    public static void main(String[] args){

        Options options = new Options();
        CommandLineParser parser = new DefaultParser();
        Map<Character,Integer> charFreqs = new HashMap<>();
        String input="";

        try{
            CommandLine commandLine = parser.parse(options, args);
            for (String str : commandLine.getArgList()){
                input += str+" ";
                str=str.toUpperCase();
                for (int i=0; i<str.length(); i++){
                    Character c = str.charAt(i);
                    if (isEnglishLetter(c)) {
                        if (charFreqs.containsKey(c)) {
                            charFreqs.put(c, charFreqs.get(c)+1);
                        } else {
                            charFreqs.put(c, 1);
                        }
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Input: "+input);
        System.out.println("Character frequencies:");
        for (Character c : charFreqs.keySet() ){
            System.out.print(String.format("%" + -5 + "s", c));
            if (charFreqs.containsKey(c)) {
                for (int i = 0; i < charFreqs.get(c); i++) {
                    System.out.print("#");
                }
            }
            System.out.println("");
        }

    }

    private static boolean isEnglishLetter(Character c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
