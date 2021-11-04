package mcash.practice.hackerrank.easy;

import java.io.*;
import java.util.*;

class BonAppetitResult {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
    public static void bonAppetit(List<Integer> bill, int ignored, int charged) {
        // Write your code here
        int total = 0;
        
        for(int i = 0; i < bill.size(); i++) {
            if(i != ignored)
                total += bill.get(i);
        }
        
        int split = total / 2;
        
        if(split == charged)
            System.out.println("Bon Appetit");
        else
            System.out.println(Math.abs(split - charged));
    }

}

public class BonAppetit {
    public static void main(String[] args) throws IOException {
        List<Integer> a = Arrays.asList(new Integer[]{3, 10, 2, 9});
        
        BonAppetitResult.bonAppetit(a, 1, 7);
        
    }
}
