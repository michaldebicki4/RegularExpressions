package com.michaldebicki;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	    String string = "I am string";
        System.out.println(string);
        String yourString = string.replaceAll("I","You");
        System.out.println(yourString);

        String alphanumeric = "abcdaF1334231";
        System.out.println(alphanumeric.replaceAll(".","Y"));

        System.out.println(alphanumeric.replaceAll("abcd","YYYY"));

        String secondString = "abcd133abcd4231";
        System.out.println(secondString.replaceAll("^abcd","YYYY"));

        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("^abcd"));
        System.out.println(alphanumeric.matches("^abcd1334231"));

        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        System.out.println(alphanumeric.replaceAll("231$","THE END"));
        System.out.println(alphanumeric.replaceAll("[aei]","X"));
        System.out.println(alphanumeric.replaceAll("[aei]","I replaced letter here"));
        System.out.println(alphanumeric.replaceAll("[aei][FJ]","X"));

        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(newAlphanumeric.replaceAll("[^ej]","X"));
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]","X"));
        System.out.println(newAlphanumeric.replaceAll("[a-f3-8]","X"));
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]","X"));
        System.out.println(newAlphanumeric.replaceAll("[0-9]","X"));
        System.out.println(newAlphanumeric.replaceAll("\\d","X"));
        System.out.println(newAlphanumeric.replaceAll("\\D","X"));

        String hasWhitespace = "I have blanks and\ta tab, and also a new line\n";
        System.out.println(hasWhitespace);
        System.out.println(hasWhitespace.replaceAll("\\s",""));
        System.out.println(hasWhitespace.replaceAll("\\t","X"));
        System.out.println(hasWhitespace.replaceAll("\\S","X"));
        System.out.println(newAlphanumeric.replaceAll("\\w","X"));
        System.out.println(hasWhitespace.replaceAll("\\w","X"));
        System.out.println(hasWhitespace.replaceAll("\\b","X"));


        String thirdAlphanumericString = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{3}", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe+", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe*", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{2,5}","YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("h+i*j","YYY"));

        StringBuilder htmlText = new StringBuilder("<h1> My heading</h2>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p> This is paragraph</p>");
        htmlText.append("<p> This is another paragraph </p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is summary</p>");

        //String h2Pattern = ".*<h2>.*";
        //String h2Pattern = "<h2>";
        String h2Pattern = "(<h2>)";
        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());
        //matcher można użyć raz

        matcher.reset();

        int count = 0;
        while (matcher.find()){
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }

        String h2GroupPattern =  "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        String h2TextGroups = "(<h2>)(.*?)(</h2)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while(h2TextMatcher.find()) {
            System.out.println("Occurrence" + h2TextMatcher.group(2));
        }

        System.out.println("harry".replaceAll("H[h]arry","Larry"));
        System.out.println("Harry".replaceAll("H[h]arry","Larry"));



        String tvTest = "tstvtkt";
        //String tNotVRegExp = "t[^v]";
        String tNotVRegExp = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while(tNotVMatcher.find()){
            count++;
            System.out.println("Occurrence "+ count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        String phone1 = "1234567890"; //not match
        String phone2 = "(123) 456-7890"; // match
        String phone3 = "123 456-7890"; //not match
        String phone4 = "(123)456-7890"; //not match

        System.out.println("phone1 = " + phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone2 = " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

    }

}
