package com.company;

import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static int commentNumber = 0;

    public static String findComment(String text) {
        commentNumber++;
        String percentComment = "%";
        String slashComment = "/*";
        String newText = "";
        if (text.contains(percentComment) && text.contains(slashComment)) {
            int percentIndex = text.indexOf("%");
            int slashIndex = text.indexOf("/*");
            if (percentIndex < slashIndex) {
                int index = text.indexOf("%");
                int last = index;
                for (int i = index+1; i < text.length(); i++) {
                    if(text.substring(i, i+1).matches("%")) {
                        last = i+1;
                        break;
                    } else {
                        last = text.length();
                    }
                }
                String comment = text.substring(index, last);
                System.out.println("COMMENT "+commentNumber+": "+comment);
                System.out.println();
                newText = text.replaceFirst(Pattern.quote(comment), Matcher.quoteReplacement(""));
                return findComment(newText);
            } else {
                int index = text.indexOf("/*");
                int last = -1;
                String comment;
                if(text.substring(index+2).contains("*/")) {
                    if(text.indexOf("*/")+1 == text.length()-1) {
                        comment = text.substring(index);
                    }
                    else {
                        last = text.indexOf("*/", index+2)+2;
                        comment = text.substring(index,last);
                    }
                } else {
                    comment = text.substring(index);
                }
                System.out.println("COMMENT "+commentNumber+": "+comment);
                System.out.println();
                newText = text.replaceFirst(Pattern.quote(comment), Matcher.quoteReplacement(""));
                return findComment(newText);
            }
        }

        else if (text.contains(percentComment) && !text.contains(slashComment)) {
            int index = text.indexOf("%");
            int last = index;
            for (int i = index+1; i < text.length(); i++) {
                if(text.substring(i, i+1).matches("%")) {
                    last = i+1;
                    break;
                } else {
                    last = text.length();
                }
            }
            String comment = text.substring(index, last);
            System.out.println("COMMENT "+commentNumber+": "+comment);
            System.out.println();
            newText = text.replaceFirst(Pattern.quote(comment), Matcher.quoteReplacement(""));
            return findComment(newText);
        }

        else if (text.contains(slashComment) && !text.contains(percentComment)){
            int index = text.indexOf("/*");
            int last = -1;
            String comment;
            if(text.substring(index+2).contains("*/")) {
                if(text.indexOf("*/")+1 == text.length()-1) {
                    comment = text.substring(index);
                }
                else {
                    last = text.indexOf("*/", index+2)+2;
                    comment = text.substring(index,last);
                }
            } else {
                comment = text.substring(index);
            }
            System.out.println("COMMENT "+commentNumber+": "+comment);
            newText = text.replaceFirst(Pattern.quote(comment), Matcher.quoteReplacement(""));
            return findComment(newText);
        }

        else {
            return "Uncommented text: "+text;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(new BufferedInputStream(System.in));
        String text = "";
        System.out.println();
        System.out.println("Enter text, a comment is closed by '%' or '/* */', or started by '%' or '/*'");
        while (reader.hasNext()) {
            String line = reader.nextLine();
            text += line + "\n";
        }
        System.out.println();
        System.out.println(findComment(text));
    }
}


