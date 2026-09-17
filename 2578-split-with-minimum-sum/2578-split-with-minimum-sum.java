class Solution {
    public int splitNum(int num) {
        char[]arr = String.valueOf(num).toCharArray();
        Arrays.sort(arr);
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        for(int i = 0;i<arr.length;i++){
            if(i%2==0){
                a.append(arr[i]);
            }else{
                b.append(arr[i]);
            }
        }
        return Integer.parseInt(a.toString())+Integer.parseInt(b.toString());
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna