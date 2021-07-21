class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans=new ArrayList<>();
        ans.add(0);   
        int digits=0;
        int cnt=1;
        
        int total =(int)Math.pow(2,n);
        while(cnt<total){
            int toXor = 1<<digits;
            int j=cnt-1;
            for(;j>=0;j--){
                int temp =ans.get(j) ^ toXor;
                ans.add(temp);
                ++cnt;
            }   
            ++digits;
        }
        
        return ans;
    }
}