package leetcode.contests.contest_313;

public class MinimizeXOR {
    public static void main(String[] args) {
        MinimizeXOR min = new MinimizeXOR();
        int res = min.minimizeXor(25, 72);
        System.out.println(res);
    }

    public int minimizeXor(int num1, int num2) {
        int bitmask = 1 << 31;
        String n1 = Integer.toBinaryString(num1 | bitmask).substring(1);

        int countSetBitn2 = countSetBits(num2);
        int countSetBitn1 = countSetBits(num1);

        StringBuilder sb = new StringBuilder(n1);
        int diff = countSetBitn2 - countSetBitn1;
        if (diff == 0) return num1;
        int i = n1.length() - 1;
        if (diff > 0) {
            while (diff != 0) {
                if (sb.charAt(i) == '0') {
                    sb.setCharAt(i, '1');
                    diff--;
                }
                i--;
            }
        } else if (diff < 0) {
            while (diff != 0) {
                if (sb.charAt(i) == '1') {
                    sb.setCharAt(i, '0');
                    diff++;
                }
                i--;
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
