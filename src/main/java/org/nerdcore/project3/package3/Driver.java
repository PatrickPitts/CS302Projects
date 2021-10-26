package org.nerdcore.project3.package3;

import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Driver {
    public static void main(String[] args) {
        String path1 = "src/main/java/org/nerdcore/project3/package3/metamorphisis_dw.txt";
        String path2 = "src/main/java/org/nerdcore/project3/package3/metamorphisis_ij.txt";
        String path3 = "src/main/java/org/nerdcore/project3/package3/translated.txt";

        Set<String> s1 = parseText(path1, new TreeSet<>());
        Set<String> s2 = parseText(path2, new TreeSet<>());
        Set<String> s3 = parseText(path3, new TreeSet<>());


        System.out.println(findSimilarity(s1, s2));
        System.out.println(findSimilarity(s3, s2));
        System.out.println(findSimilarity(s3, s1));

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
                set.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return set;
    }
}
