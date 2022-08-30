package effort_2022;

public class LC_7 {
    public int reverse(int x) {
        boolean isNeg = false;
        if (x < 0) {
            isNeg = true;
            x = x * (-1);
        }

        String str = Integer.toString(x);
        StringBuilder sb = new StringBuilder(str);
        StringBuilder rev = sb.reverse();


        String f = rev.toString();
        int result;
        try {
            result = Integer.parseInt(f);
            if (isNeg) return result * (-1);
        } catch (Exception ex) {
            result = 0;
        }
        return result;
    }
}
