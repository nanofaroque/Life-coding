package leetcode.contests.contest_314;

public class FindTheOriginalArrayOfPrefix {
    public static void main(String[] args) {
        FindTheOriginalArrayOfPrefix f=new FindTheOriginalArrayOfPrefix();
        f.findArray(new int[]{5,2,0,3,1});
    }
    public int[] findArray(int[] pref) {
        int[] result = new int[pref.length];
        result[0] = pref[0];
        int currXor=pref[0];
        for (int i = 1; i < pref.length; i++) {
            String target=intToBinary(pref[i]);
            String curr=intToBinary(currXor);

            int len=target.length();
            StringBuilder  temp=new StringBuilder();
            for(int j=len-1;j>=0;j--){
                char tc=target.charAt(j);
                char cc=curr.charAt(j);
                if(tc=='1') {
                    char c = (cc == '0' ? '1' : '0');
                    temp.append(c);
                }else{
                    char c=cc;
                    temp.append(c);
                }
            }
            result[i]=Integer.parseInt(temp.reverse().toString(),2);
            currXor^=result[i];
        }
        return result;
    }

    private String intToBinary(int num) {
        int l = 1 << 31;
        int res = l | num;
        String str = Integer.toBinaryString(res);
        return str.substring(10);
    }
}
