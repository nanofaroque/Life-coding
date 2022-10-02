package leetcode.contests.contest_313;

public class CommonFactors {
    public static void main(String[] args) {
        CommonFactors c=new CommonFactors();
        c.commonFactors(12,6);
    }
    public int commonFactors(int a, int b) {
        int t= Math.min(a, b); int res=0;

        for(int i=1;i<=t;i++){
            if(a% i ==0 && b%i ==0){
                res++;
            }
        }
        System.out.println(res);
        return res;
    }
}
