import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'longestCommonSubsequence' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static List<Integer> longestCommonSubsequence(List<Integer> a, List<Integer> b) {
    // Write your code here

     int n = a.size();
     int m = b.size();
     int dp[][] =new int[n+1][m+1];
     for(int i = 1;i<=n;i++){
        for(int j = 1;j<=m;j++){
            if(a.get(i-1).equals(b.get(j-1))){
                dp[i][j] = 1+dp[i-1][j-1];
            }
            else{
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
     }
     List<Integer> ans = new ArrayList<>();
     int i = n;
     int j = m;
    while(i>0&&j>0){
        if(a.get(i-1).equals(b.get(j-1))){
            ans.add(a.get(i-1));
            i--;
            j--;
        }
        else if(dp[i-1][j]>=dp[i][j-1]){
            i--;
        }
        else{
            j--;
        }
    }
    Collections.reverse(ans);
    return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.longestCommonSubsequence(a, b);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna