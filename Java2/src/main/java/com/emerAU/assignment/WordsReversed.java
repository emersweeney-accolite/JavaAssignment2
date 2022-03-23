package com.emerAU.assignment;

import org.apache.commons.cli.*;

import java.util.HashMap;
import java.util.Map;

public class WordsReversed {
    public static void main(String[] args) {

        Options options = new Options();
        CommandLineParser parser = new DefaultParser();
        String reversedWords = "";
        String input="";


        try {
            CommandLine commandLine = parser.parse(options, args);
            for (String str : commandLine.getArgList()) {
                input += str+" ";
                for (int i=str.length(); i>0; i--){
                    reversedWords += str.charAt(i-1);
                }
                reversedWords += " ";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Input: "+input);
        System.out.print("Output: "+reversedWords);
    }
}
