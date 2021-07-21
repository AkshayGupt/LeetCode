class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans=new ArrayList<>(k);
        
        int n=arr.length;
        
        int minDiff=Integer.MAX_VALUE;
        
        for(int y:arr){
            int diff =Math.abs(x-y);
            minDiff=Math.min(minDiff,diff);
        }
        
        
        int lptr=0;
        int rptr=n;
        for(int i=0;i<n;i++){
            if(Math.abs(arr[i]-x)== minDiff){
                lptr=i;
                rptr=i+1;
                break;
            }
        }
        
        while(k>0 && lptr>=0 && rptr<n){
            System.out.println(k+" "+lptr+" "+rptr);
            ans.add(arr[lptr--]);
            --k;
            while(k>0 && lptr>=0 && rptr<n && Math.abs(arr[rptr]-x)<Math.abs(arr[lptr]-x)){
                ans.add(arr[rptr++]);
                --k;
            }
        }
        
        while(lptr>=0 && k-->0){
            ans.add(arr[lptr--]);
        }
        
        while(rptr<n && k-->0){
            ans.add(arr[rptr++]);
        }
        
        Collections.sort(ans);
        return ans;
    }
}