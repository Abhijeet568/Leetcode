class Solution {
    public int minDeletions(int[] arr) {
        // code here
    
    int n = arr.length;
    int temp[] = new int[n];
    int size = 0;
    for(int i = 0;i<n;i++){
        int pos= lower_bound(temp,0,size,arr[i]);
        temp[pos] = arr[i];
        if(pos==size){
            size++;
        }
    }
    return n-size;
    }
    
   
    
    static int lower_bound(int arr[],int left,int right,int target ){
        if(left>=right){
            return left;
        }
        int mid = left+(right-left)/2;
        if(arr[mid]>=target){
            return lower_bound(arr,left,mid,target);
            
        }
        else{
            return lower_bound(arr,mid+1,right,target);
                
            
        }
        
    }
    static int upper_bound(int arr[],int left,int right,int target){
        if(left>=right) return left;
        int mid = left+(right-left)/2;
        if(arr[mid]>target){
            return upper_bound(arr,left,mid,target);
        }
        else{
            return upper_bound(arr,mid+1,right,target);
        }
    }
    
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna