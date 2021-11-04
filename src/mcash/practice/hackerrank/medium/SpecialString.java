/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mcash.practice.hackerrank.medium;

import java.io.*;
import java.util.*;

public class SpecialString {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        
        int counter = n;
        int consecutive = 1;    // consecutive characters that are the same
        int midIndex = -1;  // the middle index of a 3-character symmetry
                    
        // compare with previous character so start with i=1
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                // Condition 1: All of the characters are the same
                // For n consecutive characters that are the same
                // Number of palindromic strings =
                //     (n-1) + (n-2) + ... + (n-(n-1))
                counter += consecutive;
                consecutive++;
                    
                // Condition 2: All characters except the middle one
                // are the same
                if (midIndex > 0) {
                    // check for symmetry on both sides of the midIndex
                    if ((midIndex-consecutive) >= 0 && 
                            s.charAt(midIndex-consecutive) == s.charAt(i)) {
                        counter++;
                    } 
                    else {
                        // no more possibility of palindromic string with this midIndex
                        midIndex = -1; 
                    }
                }
            } 
            else {
                // reset consecutive chars counter to 1
                consecutive = 1;
                    
                // check for a 3-character symmetry
                if (((i-2) >= 0) && s.charAt(i-2) == s.charAt(i)) {
                    counter++; // 3-char symmetry is detected
                        
                    // to check if the next characters are the same
                    // and symmetrical along the midIndex
                    midIndex = i-1;
                } else {
                    midIndex = -1;
                }
            }
        }
        return counter;
    }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
