class Solution {
    public int findCenter(int[][] edges) {
            
        if(edges[0][0]==edges[1][1]){
            return  edges[0][0];

        }
       else if(edges[0][0]==edges[1][0]){
        return edges[0][0];
       }
       else if(edges[0][1]==edges[1][0]){
        return edges[0][1];
       }
      return edges[0][1];
        

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna