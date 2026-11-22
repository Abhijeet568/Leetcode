class Solution {
       int sumOdd = 0;
       int sumEven = 0;
    public int gcdOfOddEvenSums(int n) {
        
        for(int i = 1;i<=2*n;i++){
            if(i%2==0){
                sumEven+=i;
            }
            else{
                sumOdd+=i;
            }
        }
        return gcd(sumOdd,sumEven);
     
    }
    public int gcd(int a, int b){
        while(b!=0){
            int temp = b;
            b =a%b;
            a = temp;
        }
        return a;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna