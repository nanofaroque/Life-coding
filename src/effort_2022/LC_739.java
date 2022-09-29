class LC_739 {
    public int[] dailyTemperatures(int[] temp) {
        
        Deque<int[]> stack=new ArrayDeque<>();
        
        int len=temp.length;
        if(len<=1) return new int[]{};
        int[] result=new int[len];
        stack.push(new int[]{len-1, temp[len-1]});
        for(int i=len-2;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()[1]<= temp[i]){
                stack.poll();
            }
            if(stack.isEmpty()) result[i]=0;
            else{
                result[i]=stack.peek()[0]-i;
            }
            stack.push(new int[]{i, temp[i]});
        }
        return result;
        
    }
}
