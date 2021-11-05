package org.nerdcore.project3.package3;

import java.io.*;
import java.util.*;

import static java.lang.System.nanoTime;

public class Driver {
    public static void main(String[] args) {

        String path1 = "src/main/java/org/nerdcore/project3/package3/David_Wyllie_Translation.txt";
        String path2 = "src/main/java/org/nerdcore/project3/package3/Ian_Johnston_Translation.txt";
        String path3 = "src/main/java/org/nerdcore/project3/package3/Google_Translation.txt";

        System.out.println("Starting Parsing with TreeSets:");
        long timestamp = nanoTime();
        Set<String> s1 = parseText(path1, new TreeSet<>());
        Set<String> s2 = parseText(path2, new TreeSet<>());
        Set<String> s3 = parseText(path3, new TreeSet<>());

        System.out.printf("Comparison between David Wyllie and Ian Johnston translations%nSimilarity: %s%n%n", findSimilarity(s1, s2));
        System.out.printf("Comparison between Ian Johnston and Google translations%nSimilarity: %s%n%n", findSimilarity(s3, s2));
        System.out.printf("Comparison between David Wyllie and Google translations%nSimilarity: %s%n%n", findSimilarity(s3, s1));
        long treetime = nanoTime()-timestamp;
        System.out.println("Done Working with TreeSets");
        System.out.println("Starting Parsing with HashSets:\n");
        timestamp = nanoTime();
        s1 = parseText(path1, new HashSet<>());
        s2 = parseText(path2, new HashSet<>());
        s3 = parseText(path3, new HashSet<>());

        System.out.printf("Comparison between David Wyllie and Ian Johnston translations%nSimilarity: %s%n%n", findSimilarity(s1, s2));
        System.out.printf("Comparison between Ian Johnston and Google translations%nSimilarity: %s%n%n", findSimilarity(s3, s2));
        System.out.printf("Comparison between David Wyllie and Google translations%nSimilarity: %s%n%n", findSimilarity(s3, s1));
        long hashtime = nanoTime()-timestamp;

        System.out.printf("With TreeSets, building sets from .txt file and comparisons:%n%s Nanoseconds%n%n", treetime);
        System.out.printf("With HashSets, building sets from .txt file and comparisons:%n%s Nanoseconds%n%n", hashtime);

        System.out.printf("%ss are the more optimal Set implementation for this kind of problem", treetime < hashtime ? "TreeSet" : "HashSet");




    }

    public static double findSimilarity(Set<String> set1, Set<String> set2){
        int c = 0;
        for(String s : set1){
            if(set2.contains(s))c++;
        }
        return 2.0 * c/(set1.size() + set2.size());
    }

    public static Set<String> parseText(String filename, Set<String> set){

        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String str;
            while((str = br.readLine()) != null){
                for(String s : str.split(" ")){
                    if(s.length() > 0 && !Character.isAlphabetic(s.charAt(s.length()-1))){
                        s=s.substring(0, s.length()-1);
                    }
                    set.add(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return set;
    }
}
