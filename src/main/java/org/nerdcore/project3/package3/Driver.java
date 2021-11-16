/**
 * Project: Project 3
 * Completion Time: 3 hours
 *
 * Honor Code: "I pledge that I have neither given nor received help from anyone
 * other than the instructor or the TAs for all program components included here."
 */

package org.nerdcore.project3.package3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.System.nanoTime;

public class Driver {

    /**
     * main method for Driver class. Initializes several TreeSet and HashSet objects, populating them with Strings
     * from several .txt files. It tracks the time to initialize the sets by type, and calculate the similarity between
     * the different sets of that type. It compares the efficiency of the TreeSet and HashSet implementations, and reports
     * on those efficiencies as well as the similarity of the different text sets.
     */
    public static void main(String[] args) {
        /*
        TODO: Change path to files; these work in my project structure, in which this package is just one of many.
        To implement the file paths in your system, you will need to change the source directory path. File names will be the same.
        * */
        String path1 = "src/main/java/org/nerdcore/project3/package3/David_Wyllie_Translation.txt";
        String path2 = "src/main/java/org/nerdcore/project3/package3/Ian_Johnston_Translation.txt";
        String path3 = "src/main/java/org/nerdcore/project3/package3/Google_Translation.txt";

        System.out.println("Starting Parsing with TreeSets:");
        //Tracking start time for TreeSet implementation
        long timestamp = nanoTime();

        //Initializing word TreeSets with different .txt files
        Set<String> s1 = parseText(path1, new TreeSet<>());
        Set<String> s2 = parseText(path2, new TreeSet<>());
        Set<String> s3 = parseText(path3, new TreeSet<>());

        //Performing similarity algorithm with all combinations of TreeSets
        Double tree_sim12 = findSimilarity(s1, s2);
        Double tree_sim23 = findSimilarity(s3, s2);
        Double tree_sim13 = findSimilarity(s3, s1);

        //Gets total time for initialization and similarity algorithm for TreeSets
        long treetime = nanoTime() - timestamp;

        //reporting similarity results for TreeSets
        System.out.printf("Comparison between David Wyllie and Ian Johnston translations%nSimilarity: %s%n%n", tree_sim12);
        System.out.printf("Comparison between Ian Johnston and Google translations%nSimilarity: %s%n%n", tree_sim23);
        System.out.printf("Comparison between David Wyllie and Google translations%nSimilarity: %s%n%n", tree_sim13);

        System.out.println("Done Working with TreeSets");
        System.out.println("Starting Parsing with HashSets:\n");

        //Tracking start time for HashSet implementation
        timestamp = nanoTime();

        //Implementing word HashSets with different .txt files
        s1 = parseText(path1, new HashSet<>());
        s2 = parseText(path2, new HashSet<>());
        s3 = parseText(path3, new HashSet<>());

        //Performing similarity algorithm with all combinations of HashSets
        Double hash_sim12 = findSimilarity(s1, s2);
        Double hash_sim23 = findSimilarity(s3, s2);
        Double hash_sim13 = findSimilarity(s3, s1);

        //Gets total time for initialization and similarity algorithm for HashSets
        long hashtime = nanoTime() - timestamp;

        //Reporting similarity results for HashSets
        System.out.printf("Comparison between David Wyllie and Ian Johnston translations%nSimilarity: %s%n%n", hash_sim12);
        System.out.printf("Comparison between Ian Johnston and Google translations%nSimilarity: %s%n%n", hash_sim23);
        System.out.printf("Comparison between David Wyllie and Google translations%nSimilarity: %s%n%n", hash_sim13);

        //Reporting experimentally measured operation times
        System.out.printf("With TreeSets, building sets from .txt file and comparisons:%n%s Nanoseconds%n%n", treetime);
        System.out.printf("With HashSets, building sets from .txt file and comparisons:%n%s Nanoseconds%n%n", hashtime);

        //Reports optimal Set implementation
        System.out.printf("%ss are the more optimal Set implementation for this kind of problem.%n%n", treetime < hashtime ? "TreeSet" : "HashSet");

        //Determines which similarity is the highest
        Double most_sim = Math.max(hash_sim12, Math.max(hash_sim13, hash_sim23));

        //Initializes reporting Strings based on highest similarity
        String tr1, tr2;
        if (most_sim.equals(hash_sim12)) {
            tr1 = "David Wyllie";
            tr2 = "Ian Johnston";
        } else if (most_sim.equals(hash_sim13)) {
            tr1 = "David Wyllie";
            tr2 = "Google";
        } else {
            tr1 = "Ian Johnston";
            tr2 = "Google";
        }
        //reports which translations have the highest similarity
        System.out.printf("The %s and %s translations have the highest similarity of %.3f", tr1, tr2, most_sim);
    }

    /**
     * An algorithm to calculate the word similarity between two Set<String>
     * similarity = 2c/(m+n); c = count of common words, m = size of set1, n = size of set2
     * A value of 1.0 means set1 contains all Strings in set2, and set2 contains all Strings in set1.
     * A value of 0.0 means that none of the Strings in either set appear in the other set.
     *
     * @param set1 Set that contains all unique words in a particular .txt file
     * @param set2 Set that contains all unique words in a particular .txt file
     * @return numerical value of the similarity between 'set1' and 'set2'.
     */
    public static double findSimilarity(Set<String> set1, Set<String> set2) {
        int c = 0;
        //tracks the count of common words in both sets
        for (String s : set1) {
            if (set2.contains(s)) c++;
        }
        return 2.0 * c / (set1.size() + set2.size());
    }


    /**
     * This method attempts to read a .txt file indicated by the filename, extract all individual words from the
     * file, and add them individually to the 'set' parameter Set<String> object. This method assumes the file located
     * at 'filename' file path is a String-readable file, and the 'set' object is freshly initialized.
     *
     * @param filename the filepath to the .txt file to be parsed for text
     * @param set      the Set<String> object that will have all the words from the .txt file added to it
     * @return 'set', with all words from the .txt file added to it.
     */
    public static Set<String> parseText(String filename, Set<String> set) {

        //tries to read the file indicated by 'filename'
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String str;
            //iterates through the lines in 'br'
            while ((str = br.readLine()) != null) {
                //Gets all Strings in the line by splitting on spaces
                for (String s : str.split(" ")) {
                    //sanitizes trailing punctuation for each word before it to 'set'
                    if (s.length() > 0 && !Character.isAlphabetic(s.charAt(s.length() - 1))) {
                        s = s.substring(0, s.length() - 1);
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
