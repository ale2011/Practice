package mcash.practice.hackerrank.easy;

import java.io.*;
import java.util.*;
class MakingAnagramsResult {

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static int makeAnagram(String a, String b) {
        Map <Character, Integer> countMap = new HashMap <> ();
        int count = 0;
        int tmp = 0;
        
        for(char c : a.toCharArray()) {
            if(countMap.containsKey(c)) {
                tmp = countMap.get(c) + 1;                
                countMap.put(c, tmp);
            }
            else
                countMap.put(c, 1);
        }
        
        for(char c: b.toCharArray()) {
            if(countMap.containsKey(c)) {
                tmp = countMap.get(c)-1;
                countMap.put(c, tmp);
            }
            else
                countMap.put(c, -1);
        }
        
        for(int value : countMap.values()) {
            if(value != 0)
                count += Math.abs(value);
        }
        
        return count;    
    }

}

public class MakingAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = MakingAnagramsResult.makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
